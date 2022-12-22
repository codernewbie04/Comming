/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.OverviewDashboardPenggunaModel;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public interface DashboardDAO {
    public int getSaldo(int uid);
    public int getTotalProject(int uid);
    public int getTotalMentoring(int uid);
    public List<OverviewDashboardPenggunaModel> getOverview(int uid);
}
