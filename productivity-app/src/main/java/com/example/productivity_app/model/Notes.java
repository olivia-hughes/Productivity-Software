package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import java.sql.Date;
/*
--------- Notes.java ---------
Mirroring entities in the 'notes' table.
*/
public class Notes {
    private int note_id;
    private int user_id;
    private String title;
    private String content;
    private Date created_at;
    private Date updated_at;

    public Notes(){}

    public int getNote_id(){
        return note_id;
    }
    public void setNote_id(int note_id){
        this.note_id = note_id;
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

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public Date getCreated_at(){
        return created_at;
    }
    public void setCreated_at(Date created_at){
        this.created_at = created_at;
    }

    public Date getUpdated_at(){
        return updated_at;
    }
    public void setUpdated_at(Date updated_at){
        this.updated_at = updated_at;
    }
}
