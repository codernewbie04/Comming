/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUO SIO
 */
public class ProjectModel {
    private int id;
    private int author;
    private String nama;
    private String description;
    private int price_start;
    private int price_end;
    private TakenByModel taken_by;
    private int status;
    private String created_at;
    private List<BidListModel> bidList = new ArrayList();

    public ProjectModel(int id, int author, String nama, String description, int price_start, int price_end, int status, String created_at) {
        this.id = id;
        this.author = author;
        this.nama = nama;
        this.description = description;
        this.price_start = price_start;
        this.price_end = price_end;
        this.status = status;
        this.created_at = created_at;
    }
    
    public ProjectModel(int author, String nama, String description, int price_start, int price_end) {
        this.author = author;
        this.nama = nama;
        this.description = description;
        this.price_start = price_start;
        this.price_end = price_end;
    }

    public TakenByModel getTaken_by() {
        return taken_by;
    }
    
    
    public void setTakenBy(TakenByModel m) {
        this.taken_by = m;
    }

    public void add(BidListModel bidList) {
        this.bidList.add(bidList);
    }
    
    public void addAll(List<BidListModel> bidList) {
        this.bidList.addAll(bidList);
    }

    public int getId() {
        return id;
    }

    public int getAuthor() {
        return author;
    }

    public String getNama() {
        return nama;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice_start() {
        return price_start;
    }

    public int getPrice_end() {
        return price_end;
    }


    public int getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public List<BidListModel> getBidList() {
        return bidList;
    }
    
    
    
    
    
    
}
