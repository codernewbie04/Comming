/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.MentoringDAOMySQL;
import com.duo_sio.comming.model.MentorModel;
import com.duo_sio.comming.model.MentoringModel;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public class MentoringController {
    private UserModel u = new IOUserData().getUser();
    private MentoringDAOMySQL dao = new MentoringDAOMySQL();
    
    public List<MentoringModel> getMentoringPengguna() {
        List<MentoringModel> mentoring = new ArrayList();
        if(u != null)
            mentoring = dao.getMentoringPengguna(u.getId());
        return mentoring;
    }
    
    public List<MentorModel> getListMentor(){
        return dao.getListMentor();
    }
    
    public int verifyPromo(String code) {
        int cut = -1;
        if(u != null)
            cut = dao.verifyPromo(code);
        
        return cut;
    }
    
    public boolean addMentoring(String topik, int mentor,  int sesi, int price, int promo) {
        boolean stat = false;
        if(u != null)
            stat = dao.addMentoring(topik, u.getId(), mentor, sesi, price, promo);
        return stat;
    }
}
