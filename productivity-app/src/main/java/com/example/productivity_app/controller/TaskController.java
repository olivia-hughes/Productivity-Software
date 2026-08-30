package com.example.productivity_app.controller;

import com.example.productivity_app.model.Task;
import com.example.productivity_app.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
--------- TaskController.java ---------
This class is responsible for handling the Task APIs. 
This is linked directly to the methods found in TaskService.java
*/

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    /*
    test case
    @GetMapping
    public String test() {
        return "API is working!";
    }
    */ 

    // Get all tasks.
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    // Create a new task.
    @PostMapping
    public Task createTask(@RequestParam String title){
        return taskService.createTask(title);
    }

    // Delete a task by ID.
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}