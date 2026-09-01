package com.example.productivity_app.model;
/*
--------- Imports ---------
*/
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


/*
--------- Tags.java ---------
Mirroring entities in the 'tags' table.
*/
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;
    private int user_id;
    private String name;

    public Tags(){}

    public int getTag_id(){
        return tag_id;
    }
    public void setTag_id(int tag_id){
        this.tag_id = tag_id;
    }

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
}
