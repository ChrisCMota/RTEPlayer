/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.services;

import com.cct.rteplayer.models.User;
import java.util.Map;

/**
 *
 * @author Christian, 2021274
 */
public class UserService {
    
    public User createUser(
            String name,
            String email,
            String password) {
        return new User(name, email, password);
    }
    
    public User login(User userToLogin, Map<String, User> users) {
        if(!users.containsKey(userToLogin.getEmail()) ||
                isWrongPassword(userToLogin, users)) {
            System.out.println("wrong user / password");
            return null;
        }
        return users.get(userToLogin.getEmail());
    }
    
    private boolean isWrongPassword(User userToLogin, Map<String, User> users) {
        return !users.get(userToLogin.getEmail())
                .getPassword().equals(userToLogin.getPassword());
    }
}
