package com.duo_sio.comming.model;

/**
 *
 * @author DUO SIO
 */
public class TakenByModel {
    private int id;
    private String freelancer;
    private int offer;
    private String createdAt;

    public TakenByModel(int id, String freelancer, int offer, String createdAt) {
        this.id = id;
        this.freelancer = freelancer;
        this.offer = offer;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(String freelancer) {
        this.freelancer = freelancer;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
