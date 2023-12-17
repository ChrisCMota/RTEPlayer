/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.controllers;

import com.cct.rteplayer.models.Movie;
import com.cct.rteplayer.models.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author ChrisCMota, 2021274
 */
public class MenuController {
    
    private BufferedReader reader;
    
    public MenuController() {
        reader  = new BufferedReader(
            new InputStreamReader(System.in));
    }
    
    
    public Integer showPrincipalMenu(User user) {
        try {
            System.out.println("Hi, "+ user.getName());
            System.out.println("choose an option:");
            System.out.println("1 - create a new user");
            System.out.println("2 - rent a movie");
            System.out.println("3 - history rented films");
            System.out.println("4 - recommended movies");
            System.out.println("5 - exit");
            System.out.print("option: ");
            String option = reader.readLine();
            return choosedOption(option);
        } catch (IOException e) {
            return 0;
        }
    }
    
    public String rideMovieMenu (List<Movie> movies) {
        try {
            System.out.println("choose an film to ride:");
            for (int index = 0; index < movies.size(); index++) {
                StringBuilder textFilm = new StringBuilder();
                textFilm.append(index);
                textFilm.append(" - ");
                textFilm.append(movies.get(index).getName());
                textFilm.append(" - Price: ");
                textFilm.append(movies.get(index).getPrice());
                System.out.println(textFilm);
            }
            System.out.print("type your film option: ");
            String option = reader.readLine();
            Integer movieIndex = Integer.parseInt(option);
            
            if(movieIndex < 0 || movieIndex > movies.size())
                return null;
            return movies.get(movieIndex).getName();
        } catch (Exception e) {
            return null;
        }
    }
    
    private Integer choosedOption(String option) {
        try{
            if (Integer.parseInt(option) > 5 || 
                    Integer.parseInt(option) < 0 )
                return 0;
            return Integer.valueOf(option);
        }
        catch (NumberFormatException ex){
            return 0;
        }
    }
}
