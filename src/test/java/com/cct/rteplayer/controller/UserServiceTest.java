/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.rteplayer.controller;

import com.cct.rteplayer.models.User;
import com.cct.rteplayer.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author ChrisCMota
 */
public class UserServiceTest {
    
    static UserService service;
    
    @BeforeEach
    public static void setup() {
        service = new UserService();
    }
    
    @Test
    public static void createUserSuccess(){
        String name = "example";
        String email = "example@example.com";
        String password = "examplePass";     
        
        User userExpected = new User(name, email, password);
        User user =  service.createUser(name, email, password);
        
        Assertions.assertEquals(userExpected, user);
    }
    
}
