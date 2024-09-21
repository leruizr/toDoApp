package com.leruizr.toDoApp.repository;

import com.leruizr.toDoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
