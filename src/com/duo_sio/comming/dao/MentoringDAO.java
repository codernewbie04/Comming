/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.MentorModel;
import com.duo_sio.comming.model.MentoringModel;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public interface MentoringDAO {
    public List<MentoringModel> getMentoringPengguna(int uid);
    public List<MentorModel> getListMentor();
    public int verifyPromo(String code);
    public boolean addMentoring(String topik, int uid, int mentor,  int sesi, int price, int promo);
}
