package com.leruizr.toDoApp.service;

import com.leruizr.toDoApp.model.Task;
import com.leruizr.toDoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);

        return taskRepository.save(task);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }


    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(id).orElse(null);

        if (taskToUpdate == null) {
            throw new IllegalArgumentException("No se actualizó porque el ID no existe");
        }

        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("No se actualizó porque falta el título");
        }

        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("No se actualizó porque falta la descripción");
        }

        // Actualizar solo si hay un cambio real en los valores
        boolean isUpdated = false;

        if (!task.getTitle().equals(taskToUpdate.getTitle())) {
            taskToUpdate.setTitle(task.getTitle());
            isUpdated = true;
        }

        if (!task.getDescription().equals(taskToUpdate.getDescription())) {
            taskToUpdate.setDescription(task.getDescription());
            isUpdated = true;
        }

        if (!isUpdated) {
            throw new IllegalArgumentException("No se realizaron cambios porque los valores no cambiaron");
        }

        taskToUpdate.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(taskToUpdate);
    }

    public void deleteTask(Long id) {
        Task taskToDelete = taskRepository.findById(id).orElse(null);

        if (taskToDelete == null) {
            throw new IllegalArgumentException("No se eliminó porque el ID no existe");
        }

        taskRepository.deleteById(id);
    }

}
