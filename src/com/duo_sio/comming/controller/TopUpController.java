/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.TopUpDAOMySQL;
import com.duo_sio.comming.model.BalanceTrackerModel;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public class TopUpController {
    private TopUpDAOMySQL dao = new TopUpDAOMySQL();
    private final UserModel u = new IOUserData().getUser();
    
    
    public List<BalanceTrackerModel> getBalanceTracker() {
        List<BalanceTrackerModel> b = new ArrayList();
        if(u !=null)
            b = dao.getBalanceTrackerModel(u.getId());
        
        return b;
    }
}
