/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;
import com.duo_sio.comming.model.MentorModel;
import com.duo_sio.comming.model.UserModel;

/**
 *
 * @author DUO SIO
 */
public interface LoginDAO {
    public UserModel getByID(int id);
    public UserModel goLogin(String username, String password);
    public boolean isUsernameExist(String username);
    public boolean createUserPengguna(UserModel user);
    public boolean createMentor(MentorModel user);
}
