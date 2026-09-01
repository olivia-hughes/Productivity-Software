package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


/*
--------- Reminders.java ---------
Mirroring entities in the 'reminders' table.
*/
public class Reminders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int reminder_id;
    private int user_id;
    private int task_id;
    private int note_id;
    private Date reminder_time;
    private boolean is_completed;
    
    public Reminders(){}

    public int getReminder_id(){
        return reminder_id;
    }
    public void setReminder_id(int reminder_id){
        this.reminder_id = reminder_id;
    }

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public int getTask_id(){
        return task_id;
    }
    public void setTask_id(int task_id){
        this.task_id = task_id;
    }

    public int getNote_id(){
        return note_id;
    }
    public void setNote_id(int note_id){
        this.note_id = note_id;
    }

    public Date getReminder_time(){
        return reminder_time;
    }
    public void setReminder_time(Date reminder_time){
        this.reminder_time = reminder_time;
    }

    public boolean getCompleted(){
        return is_completed;
    }
    public void setCompleted(boolean is_completed){
        this.is_completed = is_completed;
    }
}
