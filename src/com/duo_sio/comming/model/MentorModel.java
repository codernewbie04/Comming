/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.model;

/**
 *
 * @author DUO SIO
 */
public class MentorModel extends UserModel {
    private int tarif;
    private String kategori;
    public MentorModel(int id, String fullname, String username, String password, int saldo, int role, String created_at, int tarif, String kategori) {
        super(id, fullname, username, password, saldo, role, created_at);
        this.tarif = tarif;
        this.kategori = kategori;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    

}
