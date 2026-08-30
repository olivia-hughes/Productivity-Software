package com.example.productivity_app.repository;

/*
--------- Imports ---------
*/
import com.example.productivity_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;;

/*
--------- TaskRepository.java ---------
*/
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
