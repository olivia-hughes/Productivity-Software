package com.example.productivity_app.model;
/*
--------- Imports ---------
Enlisting the use of jakarta persistence for its object mapping facility.
*/
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
--------- Tasks.java ---------
Mirroring entities in the 'tasks' table -- Not to be confused for Task.java, which focuses on one task at a time. 
*/
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int task_id;
    public int user_id;
    public String title;
    public String text;
    public LocalDateTime due_date;
    public String priority;
    public String status;
    public LocalDateTime created_at;

    public Tasks(){}

    public int getTask_id(){
        return task_id;
    }
    public void setTask_id(int task_id){
        this.task_id = task_id;
    }

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }

    public LocalDateTime getDue_date(){
        return due_date;
    }
    public void setDue_date(LocalDateTime due_date){
        this.due_date = due_date;
    }

    public String getPriority(){
        return priority;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public LocalDateTime getCreated_at(){
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at){
        this.created_at = created_at;
    }
}
