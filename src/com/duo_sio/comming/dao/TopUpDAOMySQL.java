/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.BalanceTrackerModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public class TopUpDAOMySQL  implements TopUpDAO{

    @Override
    public List<BalanceTrackerModel> getBalanceTrackerModel(int uid) {
        List<BalanceTrackerModel> balances = new ArrayList();
        String sql = "SELECT * FROM balance_tracker WHERE user_id = ?";
        try(PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql)){
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                //BalanceTrackerModel(int id, int user_id, String type, int amount, String created_at)
                balances.add(new BalanceTrackerModel(rs.getInt("id"), rs.getInt("user_id") , rs.getString("type"), rs.getInt("amount"), rs.getString("created_at")));
            }
            statement.close();
        } catch (Exception ex) {
            System.out.println("E:"+ex.getMessage());
        }               
        return balances;
    }
    
}
