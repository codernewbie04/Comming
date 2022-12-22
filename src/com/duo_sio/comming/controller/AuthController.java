/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.LoginDAO;
import com.duo_sio.comming.dao.LoginDAOMySQL;
import com.duo_sio.comming.model.MentorModel;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;
import java.util.Observable;

/**
 *
 * @author DUO SIO
 */
public class AuthController extends Observable{
    private LoginDAO dao = new LoginDAOMySQL();

    public void login(String u, String p) {
        UserModel user = dao.goLogin(u, p);
        
        if(user != null) {
        
        }
        setChanged();
        if (user != null){
            new IOUserData(user);
            notifyObservers(user);
        }else{
            notifyObservers();
        }
    }
    
    public boolean isUsernameExist(String username) {
        return dao.isUsernameExist(username);
    }
    
    public boolean addPenggunaOrFreelancer(String fullname, String username, String password, int role) {
        //int id, String fullname, String username, String password, int saldo, int role, String created_at
        UserModel user = new UserModel(0, fullname, username, password, 0, role, "");
        boolean stat = dao.createUserPengguna(user);
        return stat;
    }
    
    public boolean createMentor(String fullname, String username, String password, int role, int tarif, String kategori){
        MentorModel mentor = new MentorModel(0, fullname, username, password, 0, role, "", tarif, kategori);
        boolean stat = dao.createMentor(mentor);
        return stat;
    }
}
