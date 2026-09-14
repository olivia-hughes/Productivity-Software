package com.example.productivity_app.repository;
/*
--------- Imports ---------
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.example.productivity_app.DB.DBConnection;
import com.example.productivity_app.model.Notes;



/*
--------- NotesRepository.java ---------
Responsible for the endpoints connecting to the 'notes' table.
All methods use SQL statements to achieve their purpose. 
*/

@Repository
public class NotesRepository{

    /*
    ------------------------------------
    Creating a new note
    ------------------------------------
    */

    public int createNote(Notes note){
        String sql = "INSERT INTO notes (note_id, user_id, title, content, created_at, updated_at) VALUES (?,?,?,?,?,?)" ;

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, note.getNote_id());
            stmt.setInt(2, note.getUser_id());
            stmt.setString(3, note.getTitle());
            stmt.setString(4, note.getContent());
            stmt.setDate(5, Date.valueOf(note.getCreated_at()));
            stmt.setDate(6, Date.valueOf(note.getUpdated_at()));

            int affectedRows = stmt.executeUpdate();
            if(affectedRows > 0){
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
            return 0;

        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /*
    ----------------------------------
    Map ResultSet to new Notes
    ----------------------------------
    */

    private Notes mapNotes(ResultSet rs) throws SQLException{
        Notes note = new Notes();

        note.setNote_id(rs.getInt("note_id"));
        note.setUser_id(rs.getInt("user_id"));
        note.setTitle(rs.getString("title"));
        note.setContent(rs.getString("content"));
        note.getUpdated_at(rs.getDate("updated_at").toLocalDate());
        
        Date ts = rs.getDate("created_at");
        if(ts != null){
            goal.setCreated_at(ts.toLocalDate());
        }
        return note;
    }
}