package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/*
--------- NoteCategories.java ---------
Mirroring entities in the 'note_categories' table.
*/
public class NoteCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int note_id;
    private int category_id;

    public NoteCategories(){}

    public int getNote_id(){
        return note_id;
    }
    public void setNote_id(int note_id){
        this.note_id = note_id;
    }

    public int getCategory_id(){
        return category_id;
    }
    public void setCategory_id(int category_id){
        this.category_id = category_id;
    }
    
}
