package com.example.productivity_app.repository;
/*
--------- Imports ---------
*/
import com.example.productivity_app.model.Tasks;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


/*
--------- TasksRepository.java ---------
Responsible for the endpoints connecting to the 'tasks' table.
*/
@Repository
public class TasksRepository {
    private final JdbcTemplate jdbc;

    public TasksRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    /*
    ---------------------------------------
    RowMapper to map DB results for tasks from a user.
    ---------------------------------------
    */
    private final RowMapper<Tasks> mapper = (ResultSet rs, int rowNum) -> {
        Tasks task = new Tasks();

        task.setTask_id(rs.getInt("task_id"));
        task.setUser_id(rs.getInt("user_id"));
        task.setTitle(rs.getString("title"));
        task.setText(rs.getString("text"));
        task.setDue_date(rs.getDate("due_date"));
        task.setPriority(rs.getString("priority"));
        task.setStatus(rs.getString("status"));
        task.setCreated_at(rs.getDate("due_date"));
        return task;
    };


    /*
    ---------------------------------------
    ------------ Get all tasks ------------
    ---------------------------------------
    */
    public List<Tasks> getAllTasks(){
        return jdbc.query("SELECT * FROM tasks", mapper);
    }

    /*
    ---------------------------------------
    --------- Delete a task by ID ---------
    ---------------------------------------
    */
    public int deleteTaskById(int task_id){
        return jdbc.update("DELETE FROM tasks WHERE task_id = ?", task_id);
    }

    /*
    -----------------------------------------
    ------------ Save a new task ------------
    -----------------------------------------
    */
   public int save(Tasks task){
    return jdbc.update("INSERT INTO tasks (task_id, user_id, title, text, due_date, priority, status, due_date) VALUES (?,?,?,?,?,?,?,?)",
        task.getTask_id(),
        task.getUser_id(),
        task.getTitle(),
        task.getText(),
        task.getDue_date(),
        task.getPriority(),
        task.getStatus(),
        task.getCreated_at()
    );
   }

   /*
    ----------------------------------------------------
    ------------ Search for a task by title ------------
    ----------------------------------------------------
    */

    public Tasks getTaskByTitle(String title){
        try{
            List<Tasks> results = jdbc.query("SELECT * FROM tasks WHERE(title) = LOWER(?)", mapper, title);
            
            return results.isEmpty() ? null : results.get(0);

        } catch (Exception e){
            return null;
        }
    }
}
