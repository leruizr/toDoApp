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

    // Método para crear una nueva tarea
    public Task createTask(Task task) {

        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);

        return taskRepository.save(task);
    }

    // Método para consultar todas las tareas

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Método para consultar una tarea por su id

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Método para actualizar una tarea por su id

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(id).orElse(null);

        if (taskToUpdate == null) {
            return null;
        }

        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(taskToUpdate);
    }

    // Método para eliminar una tarea por su id

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
