package com.example.productivity_app.model;

/*
--------- Imports ---------
*/
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/*
--------- GoalTasks.java ---------
Mirroring entities in the 'goal_tasks' table.
*/
public class GoalTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_id;
    private int task_id;

    public GoalTasks(){}

    public int getGoal_id(){
        return goal_id;
    }
    public void setGoal_id(int goal_id){
        this.goal_id = goal_id;
    }
    
    public int getTask_id(){
        return task_id;
    }
    public void setTask_id(int task_id){
        this.task_id = task_id;
    }
}
