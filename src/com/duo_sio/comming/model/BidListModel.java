/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.model;

/**
 *
 * @author DUO SIO
 */
public class BidListModel {
    private int id;
    private int offer;
    private UserModel user;

    public BidListModel(int id, int offer, UserModel user) {
        this.id = id;
        this.offer = offer;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public int getOffer() {
        return offer;
    }

    public UserModel getUser() {
        return user;
    }
    
    
    
}
