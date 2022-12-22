/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.LoginModel;
import com.duo_sio.comming.model.UserModel;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUO SIO
 */
public class ProfileDAOMySQL implements ProfileDAO {

    @Override
    public UserModel getProfile(int uid) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            
            ResultSet rs = statement.executeQuery();
            UserModel user = null;
            if(rs.next()){
                //int id, String fullname, String username, String password, int saldo, int role, String created_at
                if(rs.getInt("role") != 2)
                    user = new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("password"), rs.getInt("saldo"), rs.getInt("role"), rs.getString("created_at"));
            }
            statement.close();
            return user;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateName(int uid, String name) {
       boolean success = false;
        String sql = "UPDATE users SET fullname = ? WHERE id = ?";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setString(1, name);
            statement.setInt(2, uid);
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

    @Override
    public void kurangiSaldo(int uid, int jumlah) {
        String sql = "UPDATE users SET saldo = saldo - ? WHERE id = ?";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setInt(1, jumlah);
            statement.setInt(2, uid);
            System.out.println(statement.executeUpdate());
            DatabaseMySQL.getConnection().commit();
            statement.close();
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
    }

    @Override
    public void updateBalanceTracker(int uid, String type, int amount) {
        String sql = "INSERT INTO balance_tracker(user_id, type, amount) VALUES(?, ?, ?)";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, uid);
            statement.setString(2, type);
            statement.setInt(3, amount);
            System.out.println(statement.executeUpdate());
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                     System.out.println("Creating user failed, no ID obtained.");
                }
                   
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
    }

    @Override
    public void tambahSaldo(int uid, int jumlah) {
        String sql = "UPDATE users SET saldo = saldo + ? WHERE id = ?";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setInt(1, jumlah);
            statement.setInt(2, uid);
            System.out.println(statement.executeUpdate());
            DatabaseMySQL.getConnection().commit();
            statement.close();
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
    }
    
}
