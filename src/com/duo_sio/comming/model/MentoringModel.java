/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.model;

/**
 *
 * @author DUO SIO
 */
public class MentoringModel {
    private int id;
    private String topik;
    private String pengguna;
    private String mentor;
    private int sesi;
    private int price;
    private int promo;
    private int total_price;
    private int status;
    private String created_at;

    public MentoringModel(int id, String topik, String pengguna, String mentor, int sesi, int price, int promo, int total_price, int status, String created_at) {
        this.id = id;
        this.topik = topik;
        this.pengguna = pengguna;
        this.mentor = mentor;
        this.sesi = sesi;
        this.price = price;
        this.promo = promo;
        this.total_price = total_price;
        this.status = status;
        this.created_at = created_at;
    }

    public int getSesi() {
        return sesi;
    }
 
    public int getId() {
        return id;
    }

    public String getTopik() {
        return topik;
    }

    public String getPengguna() {
        return pengguna;
    }

    public String getMentor() {
        return mentor;
    }

    public int getPrice() {
        return price;
    }

    public int getPromo() {
        return promo;
    }

    public int getTotal_price() {
        return total_price;
    }

    public int getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }
    
}
