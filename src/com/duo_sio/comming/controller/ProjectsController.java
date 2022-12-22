/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.controller;

import com.duo_sio.comming.dao.ProjectsDAOMySQL;
import com.duo_sio.comming.model.ProjectModel;
import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public class ProjectsController {
    private UserModel u = new IOUserData().getUser();
    private ProjectsDAOMySQL dao = new ProjectsDAOMySQL();
    
    public List<ProjectModel> getProjects() {
        List<ProjectModel> projects = new ArrayList();
        if(u !=null)
            projects = dao.getProject(u.getId());
        return projects;
    }
    
    public boolean createProject(String nama, String description, int start, int end){
        boolean stat = false;
        if(u != null){
            ProjectModel project = new ProjectModel(u.getId(), nama, description, start, end);
            stat = dao.createProject(project);
        }
        return stat;
    }
    
    public boolean setTakenBy(int project_id, int bid_id) {
        boolean stat = false;
        if(u != null){
            stat = dao.setTakenBy(project_id, bid_id);
        }
        return stat;
    }
}
