/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.UserModel;

/**
 *
 * @author DUO SIO
 */
public interface ProfileDAO {
        public UserModel getProfile(int uid);
        public boolean updateName(int uid, String name);
        public void kurangiSaldo(int uid, int jumlah);
        public void tambahSaldo(int uid, int jumlah);
        public void updateBalanceTracker(int uid, String type, int amount);
}
