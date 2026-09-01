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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String password_hash;
    private LocalDateTime created_at;
    
    public Users(){}

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword_hash(){
        return password_hash;
    }
    public void setPassword_hash(String password_hash){
        this.password_hash = password_hash;
    }

    public LocalDateTime getCreated_at(){
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at){
        this.created_at = created_at;
    }
}
