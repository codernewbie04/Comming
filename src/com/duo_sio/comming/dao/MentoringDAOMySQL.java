/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.LoginModel;
import com.duo_sio.comming.model.MentorModel;
import com.duo_sio.comming.model.MentoringModel;
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
public class MentoringDAOMySQL implements MentoringDAO{

    @Override
    public List<MentoringModel> getMentoringPengguna(int uid) {
        List<MentoringModel> mentoring = new ArrayList();
        String sql = "SELECT mentoring.*, users.fullname AS pengguna_name, u2.fullname AS mentor_name FROM mentoring JOIN users ON mentoring.pengguna = users.id JOIN users AS u2 ON mentoring.mentor = u2.id WHERE pengguna = ?";
        
        try(java.sql.PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                //int id, String topik, int pengguna, int mentor, int price, int promo, int total_price, int status, String created_at
                mentoring.add(new MentoringModel(rs.getInt("id"), rs.getString("topik"), rs.getString("pengguna_name"), rs.getString("mentor_name"), rs.getInt("sesi"), rs.getInt("price"), rs.getInt("promo"), rs.getInt("total_price"), rs.getInt("status"), rs.getString("created_at")));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        return mentoring;
    }

    @Override
    public List<MentorModel> getListMentor() {
        List<MentorModel> mentor = new ArrayList();
        String sql = "SELECT users.*, additional_mentor.tarif,additional_mentor.kategori FROM users JOIN additional_mentor ON additional_mentor.user_id = users.id";
        
        try(java.sql.PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                mentor.add(new MentorModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), "idk", rs.getInt("saldo"), rs.getInt("role"), rs.getString("created_at"), rs.getInt("tarif"), rs.getString("kategori")));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        return mentor;
    }

    @Override
    public int verifyPromo(String code) {
        String sql = "SELECT * FROM promo WHERE code = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setString(1, code);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt("cut");
            }
            statement.close();
            return -1;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }

    @Override
    public boolean addMentoring(String topik, int uid, int mentor,  int sesi, int price, int promo) {
        boolean success = false;
        String sql = "INSERT INTO mentoring(topik, pengguna, mentor, sesi, price, promo, total_price) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement=null;
        try{
            statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            DatabaseMySQL.getConnection().setAutoCommit(false);
            statement.setString(1, topik);
            statement.setInt(2, uid);
            statement.setInt(3, mentor);
            statement.setInt(4, sesi);
            statement.setInt(5, price);
            statement.setInt(6, promo);
            statement.setInt(7, price - promo);
            
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
    
}
