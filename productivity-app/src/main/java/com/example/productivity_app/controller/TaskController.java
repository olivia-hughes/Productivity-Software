package com.example.productivity_app.controller;

import com.example.productivity_app.model.Task;
import com.example.productivity_app.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
--------- TaskController.java ---------
This class is responsible for handling the Task APIs. 
*/

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestParam String title){
        return taskService.createTask(title);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
