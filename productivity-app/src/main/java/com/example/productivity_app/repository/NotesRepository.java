package com.example.productivity_app.repository;
/*
--------- Imports ---------
*/
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.productivity_app.DB.DBConnection;
import com.example.productivity_app.model.Notes;



/*
--------- NotesRepository.java ---------
Responsible for the endpoints connecting to the 'notes' table.
All methods use SQL statements to achieve their purpose. 

Notes will require the ability to:
- Be created (all attributes)
- Be updated (content, title, updated_at)
- Be deleted (all attributes)
- Be displayed (fetch all notes by user)
*/

@Repository
public class NotesRepository{
    /*
    ----------------------------------
    Map ResultSet to new Notes
    This is responsible for converting database query results into Java objects 
    using type conversion between database and Java (processing JDBC 'ResultSet' objects).
    ----------------------------------
    */

    private Notes mapNotes(ResultSet rs) throws SQLException{
        Notes note = new Notes();

        note.setNote_id(rs.getInt("note_id"));
        note.setUser_id(rs.getInt("user_id"));
        note.setTitle(rs.getString("title"));
        note.setContent(rs.getString("content"));
        note.setUpdated_at(rs.getDate("updated_at").toLocalDate());
        
        Date ts = rs.getDate("created_at");
        if(ts != null){
            note.setCreated_at(ts.toLocalDate());
        }
        return note;
    }

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
    ---------------------------------------
    Delete a note by its note_id
    ---------------------------------------
    */
    public boolean deleteNote(int note_id){
        String sql = "DELETE FROM notes WHERE note_id = ?";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, note_id);
            return stmt.executeUpdate()>0;
        } catch (Exception e){
            return false;
        }
    }

    /*
    ---------------------------------------
    Updating a note's content, title, updated_at time.
    ---------------------------------------
    */
    public boolean updateNote(Notes req){
        String sql = "UPDATE notes SET title = ?, content = ?, updated_at = ?";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, req.getTitle());
            stmt.setString(2, req.getContent());
            stmt.setDate(3, Date.valueOf(req.getUpdated_at()));

            return stmt.executeUpdate()>0;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    ---------------------------------------
    Fetching user notes
    Gets all notes by a user. 
    ---------------------------------------
    */
    public List<Notes> getNotesByUser(int user_id){
        List<Notes> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE user_id = ?";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                notes.add(mapNotes(rs));
            } 
        } catch (Exception e){
            e.printStackTrace();
        }
    return notes;
    }
}