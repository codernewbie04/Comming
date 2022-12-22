/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.BalanceTrackerModel;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public interface TopUpDAO {
    public List<BalanceTrackerModel> getBalanceTrackerModel(int uid);
}
