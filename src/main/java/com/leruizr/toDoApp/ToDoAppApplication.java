package com.leruizr.toDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.leruizr.toDoApp")
public class ToDoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}
}
