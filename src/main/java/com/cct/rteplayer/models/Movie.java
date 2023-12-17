/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.models;

/**
 *
 * @author Marcus, 2021304
 */
public class Movie {
    private String name;
    private Double price;
    
    public Movie(){}
    
    public Movie(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
