/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.models;

import java.time.LocalDateTime;

/**
 *
 * @author Marcus, 2021304
 */
public class Ride {
    private String userEmail;
    private String movieName;
    private LocalDateTime startRide;
    private LocalDateTime endRide;
    
    
    public Ride() {}
    
    public Ride(String userEmail, String movieName, LocalDateTime startRide, 
            LocalDateTime endRide) {
        this.userEmail = userEmail;
        this.movieName = movieName;
        this.startRide = startRide;
        this.endRide = endRide;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    public String getMovieName() {
        return movieName;
    }
    public LocalDateTime getStartRide() {
        return startRide;
    }
    public LocalDateTime getEndRide() {
        return endRide;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public void setStartRide(LocalDateTime startRide) {
        this.startRide = startRide;
    }
    
    public void setEndRide(LocalDateTime endRide) {
        this.endRide = endRide;
    }
}
