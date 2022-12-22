/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duo_sio.comming.dao;

import com.duo_sio.comming.model.ProjectModel;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public interface ProjectsDAO {
    public List<ProjectModel> getProject(int uid);
    public boolean createProject(ProjectModel p);
    public boolean setTakenBy(int project_id, int bid_id);
    
}
