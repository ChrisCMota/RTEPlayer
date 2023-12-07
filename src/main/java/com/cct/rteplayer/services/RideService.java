/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.services;

import com.cct.rteplayer.models.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ChrisCMota
 */
public class RideService {
    
    public List<Movie> chargeMovies() {
       List<Movie> movies = new ArrayList<>();        
        try (BufferedReader br = new BufferedReader(new FileReader("movies.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                movies.add(new Movie(values[0], Double.valueOf(values[1])));
            }
            
            return movies;
        } catch(Exception e) {
            System.out.print("Error on charge movies");
        }
        
        return null;
    }
    
}
