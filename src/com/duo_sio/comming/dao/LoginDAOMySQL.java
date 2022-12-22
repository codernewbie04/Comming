/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.LoginModel;
import com.duo_sio.comming.model.MentorModel;
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
public class LoginDAOMySQL implements LoginDAO{
    @Override
    public UserModel getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserModel goLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setString(1, username);
            statement.setString(2, password);
            
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
    public boolean isUsernameExist(String username) {
        boolean exist = false;
        String sql = "SELECT * FROM users WHERE username = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            UserModel user = null;
            if(rs.next()){
                exist = true;
            }
            statement.close();
            return exist;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }

    @Override
    public boolean createUserPengguna(UserModel user) {
        boolean success = false;
        String sql = "INSERT INTO users(fullname, username, password, saldo, role) VALUES(?, ?, ?, 0, ?)";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole());
            System.out.println(statement.executeUpdate());
            DatabaseMySQL.getConnection().commit();
            statement.close();
            return true;
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
    public boolean createMentor(MentorModel user) {
        boolean success = false;
        String sql = "INSERT INTO users(fullname, username, password, saldo, role) VALUES(?, ?, ?, 0, ?)";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole());
            System.out.println(statement.executeUpdate());
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    if(this.insertAdditionalMentor(generatedKeys.getInt(1), user.getTarif(), user.getKategori())){
                        success = true;
                    } else {
                        DatabaseMySQL.getConnection().rollback();
                    }
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
    
    private boolean insertAdditionalMentor(int uid, int tarif, String kategori) {
        String sql = "INSERT INTO additional_mentor(user_id, tarif, kategori) VALUES(?, ?, ?)";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, uid);
            statement.setInt(2, tarif);
            statement.setString(3, kategori);
            System.out.println(statement.executeUpdate());
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return true;
                } else {
                    System.out.println("Creating user failed, no ID obtained.");
                }
            }
            statement.close();
            return false;
        } catch (Exception ex) {
        }
        
        return false;
    }
    
}
