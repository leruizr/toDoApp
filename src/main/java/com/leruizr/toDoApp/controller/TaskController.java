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

    // Endpoint para consultar una tarea por su id

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        Task task = taskService.getTaskById(id);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // Endpoint para actualizar una tarea por su id

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Endpoint para eliminar una tarea por su id

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
