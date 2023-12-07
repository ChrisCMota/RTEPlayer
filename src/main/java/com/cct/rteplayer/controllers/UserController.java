/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.controllers;

import com.cct.rteplayer.models.User;
import com.cct.rteplayer.services.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author ChrisCMota
 */
public class UserController {
    
    private static UserService service;
    private BufferedReader reader;
    
    public UserController() {
        service = new UserService();
        reader  = new BufferedReader(
            new InputStreamReader(System.in));
    }
    
    public User createUser() {
        try {
            System.out.print("type your name: ");
            String name = reader.readLine();
            System.out.print("type your email: ");
            String email = reader.readLine();
            System.out.print("type your password: ");
            String password = reader.readLine();
            return service.createUser(name, email, password);
        } catch (IOException e) {
            System.out.println("Error on add user, please try again");
            return null;
        }
    }
    
    public User makeLogin(Map<String, User> users) {
        try {
            System.out.print("type your email: ");
            String email = reader.readLine();
            System.out.print("type your password: ");
            String password = reader.readLine();
            
            User userToLogin = new User();
            userToLogin.setEmail(email);
            userToLogin.setPassword(password);
            
            return service.login(userToLogin, users);
            
        } catch (IOException e) {
            System.out.println("Error on add user, please try again");
            return null;
        }
    }
    
}
