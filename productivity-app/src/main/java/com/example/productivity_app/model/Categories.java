package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/*
--------- Categories.java ---------
Mirroring entities in the 'categories' table.
*/
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private int user_id;
    private String name;

    public Categories(){}

    public int getcategory_id(){
        return category_id;
    }
    public void setcategory_id(int category_id){
        this.category_id = category_id;
    }

    public int getuser_id(){
        return user_id;
    }
    public void setuser_id(int user_id){
        this.user_id = user_id;
    }

    public String getName(){
        return name;
    }
    public void setName_id(String name){
        this.name = name;
    }
    
}
