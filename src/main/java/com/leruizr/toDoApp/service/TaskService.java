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
}
