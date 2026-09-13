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
import com.example.productivity_app.model.Goals;

/*
--------- GoalRepository.java ---------
Responsible for the endpoints connecting to the 'goals' table.
All methods use SQL statements to achieve their purpose. 
*/

@Repository 
public class GoalRepository {
    
    /*
    ---------------------------------------
    Creating a user goal
    Inserts all goal-related values into the 'goals' table. 
    ---------------------------------------
    */
    public int createGoal(Goals goal){
        String sql = "INSERT INTO goals (goal_id, user_id, title, description, status) VALUES (?,?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setInt(1, goal.getGoal_id());
            stmt.setInt(2, goal.getUser_id());
            stmt.setString(3, goal.getTitle());
            stmt.setString(4, goal.getDescription());
            stmt.setString(5, goal.getStatus());
            stmt.setDate(6, Date.valueOf(goal.getTarget_date()));
            stmt.setDate(7, Date.valueOf(goal.getCreated_at()));

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
    Map ResultSet to new Goals 
    ---------------------------------------
    */
    private Goals mapGoal(ResultSet rs) throws SQLException{
        Goals goal = new Goals();

        goal.setGoal_id(rs.getInt("goal_id"));
        goal.setUser_id(rs.getInt("user_id"));
        goal.setTitle(rs.getString("title"));
        goal.setDescription(rs.getString("description"));
        goal.setStatus(rs.getString("status"));
        goal.setTarget_date(rs.getDate("target_date").toLocalDate());

        Date ts = rs.getDate("created_at");
        if(ts != null){
            goal.setCreated_at(ts.toLocalDate());
        }

        return goal;
    }

    /*
    ---------------------------------------
    Fetching user goals
    Gets all goals for a user. 
    ---------------------------------------
    */
    public List<Goals> getGoalsByUser(int user_id){
        List<Goals> goals = new ArrayList<>();

        String sql = "SELECT * FROM goals WHERE user_id = ?";
        
        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                goals.add(mapGoal(rs));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return goals;
    }

    /*
    ---------------------------------------
    Delete a user goal by its goal_id
    ---------------------------------------
    */
    public boolean deleteGoal(int goal_id){
        String sql = "DELETE FROM goals WHERE goal_id = ?";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, goal_id);
            return stmt.executeUpdate()>0;

        } catch (Exception e){
            return false;
        }
    }

    /*
    ---------------------------------------
    Update a goal's status
    ---------------------------------------
    */
    public boolean updateGoalStatus(int goal_id, String status){
        String sql = "UPDATE goals SET status = ? WHERE goal_id = ?";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, status);
            stmt.setInt(2, goal_id);

            return stmt.executeUpdate()>0;

        } catch (Exception e){
            return false;
        }
    }

    /*
    ---------------------------------------
    Fetch goals by status
    ---------------------------------------
    */
   public List<Goals> getGoalsByStatus(int user_id, String status){
    String sql = "SELECT * FROM goals WHERE user_id = ? AND goal_status = ?";

    List<Goals> goals = new ArrayList<>();

    try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setInt(1, user_id);
        stmt.setString(2, status);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            goals.add(mapGoal(rs));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return goals;
    }
 
    /*
    ---------------------------------------
    Updating a goal
    ---------------------------------------
    */
    public boolean updateGoal(Goals req){
        String sql = "UPDATE goals SET title = ?, description = ?, status = ?, target_date = ? WHERE goal_id = ? AND user_id = ?";
        // No need to get the created_at date, since this won't change. 

        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, req.getTitle());
            stmt.setString(2, req.getDescription());
            stmt.setString(3, req.getStatus());
            stmt.setDate(4, Date.valueOf(req.getTarget_date()));
            stmt.setInt(5, req.getGoal_id());
            stmt.setInt(6, req.getUser_id());

            return stmt.executeUpdate() > 0;

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

