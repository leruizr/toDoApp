package com.leruizr.toDoApp.controller;

import com.leruizr.toDoApp.model.Task;
import com.leruizr.toDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Endpoint para crear una nueva tarea

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        Task createdTask = taskService.createTask(task);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Endpoint para consultar todas las tareas

    @GetMapping
    public ResponseEntity<Iterable<Task>> getAllTasks() {

        Iterable<Task> tasks = taskService.getAllTasks();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
