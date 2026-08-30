package com.example.productivity_app.service;

/*
--------- Imports ---------
*/
import com.example.productivity_app.model.Task;
import com.example.productivity_app.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/*
--------- TaskService.java ---------
*/
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // Simple function to get all tasks. 
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // Create a new task.
    public Task createTask(String title){
        Task task = new Task(title);
        return taskRepository.save(task);
    }

    // Delete a task.
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
