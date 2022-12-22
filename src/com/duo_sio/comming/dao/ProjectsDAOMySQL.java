/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.BidListModel;
import com.duo_sio.comming.model.LoginModel;
import com.duo_sio.comming.model.OverviewDashboardPenggunaModel;
import com.duo_sio.comming.model.ProjectModel;
import com.duo_sio.comming.model.TakenByModel;
import com.duo_sio.comming.model.UserModel;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUO SIO
 */
public class ProjectsDAOMySQL implements ProjectsDAO {

    @Override
    public List<ProjectModel> getProject(int uid) {
        List<ProjectModel> projects = new ArrayList();
        
        String sql = "SELECT * FROM projects WHERE author = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                ProjectModel project = new ProjectModel(rs.getInt("id"), rs.getInt("author"), rs.getString("nama"), rs.getString("description"), rs.getInt("price_start"), rs.getInt("price_end"), rs.getInt("status"), rs.getString("created_at"));
                project.addAll(getBidList(rs.getInt("id")));
                if(rs.getInt("taken_by") != 0){
                    project.setTakenBy(getTakenBy(rs.getInt("taken_by")));
                }
                projects.add(project);
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        
        return projects;
    }
    
    private List<BidListModel> getBidList(int pid) {
        List<BidListModel> bidList = new ArrayList();
        
        String sql = "SELECT *,users.id as uid FROM bid_project JOIN users ON bid_project.freelancer = users.id WHERE bid_project.project_id = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, pid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                //int id, int author, String nama, String description, int price_start, int price_end, int taken_by, int status, String created_at
                UserModel freelancer = new UserModel(rs.getInt("uid"), rs.getString("fullname"), rs.getString("username"), "*", rs.getInt("saldo"), rs.getInt("role"), rs.getString("created_at"));
                bidList.add(new BidListModel(rs.getInt("id"), rs.getInt("offer"), freelancer));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        
        return bidList;
    }
    
    private TakenByModel getTakenBy(int bid_id){
        TakenByModel taken = null;
        String sql = "SELECT bid_project.*, users.fullname as freelancer_name FROM bid_project JOIN users ON bid_project.freelancer = users.id WHERE bid_project.id=?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, bid_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                taken = new TakenByModel(rs.getInt("id"), rs.getString("freelancer_name"), rs.getInt("offer"), rs.getString("created_at"));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        return taken;
    }

    @Override
    public boolean createProject(ProjectModel p) {
        boolean success = false;
        String sql = "INSERT INTO projects(author, nama, description, price_start, price_end) VALUES(?,?,?,?,?)";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setInt(1, p.getAuthor());
            statement.setString(2, p.getNama());
            statement.setString(3, p.getDescription());
            statement.setInt(4, p.getPrice_start());
            statement.setInt(5, p.getPrice_end());
            System.out.println(statement.executeUpdate());
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    success = true;
                } else {
                    DatabaseMySQL.getConnection().rollback();
                    System.out.println("Creating user failed, no ID obtained.");
                }
            }
            DatabaseMySQL.getConnection().commit();
            statement.close();
            return success;
        } catch (Exception ex) {
            try {
                DatabaseMySQL.getConnection().rollback();
            } catch (Exception ex1) {
                Logger.getLogger(LoginDAOMySQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseMySQL.getConnection().setAutoCommit(true);
                if (statement == null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return success;
    }

    @Override
    public boolean setTakenBy(int project_id, int bid_id) {
        boolean success = false;
        String sql = "UPDATE projects SET taken_by = ?, status = 1 WHERE id = ?";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setInt(1, bid_id);
            statement.setInt(2, project_id);
            System.out.println(statement.executeUpdate());
            DatabaseMySQL.getConnection().commit();
            statement.close();
            success = true;
        } catch (Exception ex) {
            try {
                DatabaseMySQL.getConnection().rollback();
            } catch (Exception ex1) {
                Logger.getLogger(LoginDAOMySQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseMySQL.getConnection().setAutoCommit(true);
                if (statement == null) {
                    statement.close();
                }
 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return success;
    }
    
}
