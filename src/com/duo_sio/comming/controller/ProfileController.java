/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.ProfileDAOMySQL;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;

/**
 *
 * @author DUO SIO
 */
public class ProfileController {
    private ProfileDAOMySQL dao = new ProfileDAOMySQL();
    private final UserModel u = new IOUserData().getUser();
    
    public UserModel getUser() {
        UserModel newUserData = null;
        if(u != null){
            newUserData = dao.getProfile(u.getId());
        }
        return newUserData;
    }
    
    public boolean updateName(String name){
        boolean stat = false;
        if(u != null){
            stat = dao.updateName(u.getId(), name);
        }
        return stat;
    }
    
    public void kurangiSaldo(int jumlah){
        if(u != null){
            dao.kurangiSaldo(u.getId(), jumlah);
            addMoneyTracker(u.getId(), "out", jumlah);
        }    
    }
    
    public void tambahSaldo(int uid, int jumlah){
        if(uid == -1){
            uid = u.getId();
        }
        dao.tambahSaldo(uid, jumlah);
        addMoneyTracker(uid, "in", jumlah);
    }
    
    public void addMoneyTracker(int uid, String type, int amount){
        if(u != null)
            dao.updateBalanceTracker(uid, type, amount);
    }
}
