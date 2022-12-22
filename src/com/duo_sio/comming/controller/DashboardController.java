/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.DashboardDAOMySQL;
import com.duo_sio.comming.model.Model_Card;
import com.duo_sio.comming.model.OverviewDashboardPenggunaModel;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.CommonUtils;
import com.duo_sio.comming.utils.IOUserData;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 * @author DUO SIO
 */
public class DashboardController extends Observable {
    private DashboardDAOMySQL dao = new DashboardDAOMySQL();
    private final UserModel u = new IOUserData().getUser();
    public List<Model_Card> getCardPengguna() {
        List<Model_Card> card = new ArrayList();
        
        if(u!=null){
            card.add(new Model_Card(new ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/money.png")), "Saldo", CommonUtils.getFormattedPrice(dao.getSaldo(u.getId())), ""));
            card.add(new Model_Card(new ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/project.png")), "Total Project Created",String.valueOf(dao.getTotalProject(u.getId())), ""));
            card.add(new Model_Card(new ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/mentor.png")), "Total Mentoring", String.valueOf(dao.getTotalMentoring(u.getId())), ""));
        }
        return card;
    }
    
    public List<OverviewDashboardPenggunaModel> getOverviewPengguna() {
        List<OverviewDashboardPenggunaModel> overview = new ArrayList();
        if(u !=null)
            overview = dao.getOverview(u.getId());
        return overview;
    }
}
