package com.example.productivity_app.repository;
/*
--------- Imports ---------
*/

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.productivity_app.model.Reminders;

/*
--------- RemindersRepository.java ---------
Responsible for the endpoints connecting to the 'reminders' table.
All methods use SQL statements to achieve their purpose. 

Reminders will need the ability to:
- Be created
- Be updated (reminder_time)
- Be completed
- Be deleted
*/
@Repository 
public class RemindersRepository {

    /*
    ---------------------------------------
    Map ResultSet to new Goals 
    This is responsible for converting database query results into Java objects 
    using type conversion between database and Java (processing JDBC 'ResultSet' objects).
    ---------------------------------------
    */
    private Reminders mapReminders(ResultSet rs) throws SQLException{
        Reminders reminder = new Reminders();

        reminder.setReminder_id(rs.getInt("reminder_id"));
        reminder.setUser_id(rs.getInt("user_id"));
        reminder.setTask_id(rs.getInt("task_id"));
        reminder.setNote_id(rs.getInt("note_id"));
        reminder.setReminder_time(rs.getDate("reminder_time").toLocalDate());
        reminder.setCompleted(rs.getBoolean("is_completed"));

        return reminder;
    }



}
