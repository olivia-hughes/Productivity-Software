package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

/*
--------- Goals.java ---------
Mirroring entities in the 'goals' table.
*/
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_id;
    private int user_id;
    private String title;
    private String description;
    private String status;
    private LocalDate target_date;
    private LocalDate created_at;
    
    public Goals(){}

    public int getGoal_id(){
        return goal_id;
    }
    public void setGoal_id(int goal_id){
        this.goal_id = goal_id;
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

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getTarget_date(){
        return target_date;
    }
    public void setTarget_date(LocalDate target_date){
        this.target_date = target_date;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public LocalDate getCreated_at(){
        return created_at;
    }
    public void setCreated_at(LocalDate created_at){
        this.created_at = created_at;
    }

}
