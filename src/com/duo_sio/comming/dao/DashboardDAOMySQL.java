/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.LoginModel;
import com.duo_sio.comming.model.OverviewDashboardPenggunaModel;
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
public class DashboardDAOMySQL implements DashboardDAO{
    @Override
    public int getSaldo(int uid) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            int saldo =0;
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                //int id, String fullname, String username, String password, int saldo, int role, String created_at
                saldo = rs.getInt("saldo");
            }
            statement.close();
            return saldo;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getTotalProject(int uid) {
        String sql = "SELECT COUNT(id) AS jumlah FROM projects WHERE author = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            int totalProject =0;
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                //int id, String fullname, String username, String password, int saldo, int role, String created_at
                totalProject = rs.getInt("jumlah");
            }
            statement.close();
            return totalProject;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getTotalMentoring(int uid) {
        String sql = "SELECT COUNT(id) AS jumlah FROM mentoring WHERE pengguna = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            int totalProject =0;
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                //int id, String fullname, String username, String password, int saldo, int role, String created_at
                totalProject = rs.getInt("jumlah");
            }
            statement.close();
            return totalProject;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<OverviewDashboardPenggunaModel> getOverview(int uid) {
        List<OverviewDashboardPenggunaModel> o = new ArrayList();
        o.addAll(getOverviewMentoring(uid));
        o.addAll(getOverviewProject(uid));
        return o;
    }
    
    private List<OverviewDashboardPenggunaModel> getOverviewMentoring(int uid) {
        List<OverviewDashboardPenggunaModel> m = new ArrayList();
        
        String sql = "SELECT * FROM mentoring WHERE pengguna = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                m.add(new OverviewDashboardPenggunaModel("Mentoring", rs.getInt("total_price"), rs.getString("topik"), rs.getString("created_at"), rs.getInt("status")));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        
        return m;
    }
    
    private List<OverviewDashboardPenggunaModel> getOverviewProject(int uid) {
        List<OverviewDashboardPenggunaModel> m = new ArrayList();
        
        String sql = "SELECT * FROM projects WHERE author = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                m.add(new OverviewDashboardPenggunaModel("Project", rs.getInt("price_end"), rs.getString("nama"), rs.getString("created_at"), rs.getInt("status")));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }
        
        return m;
    }
    
}
