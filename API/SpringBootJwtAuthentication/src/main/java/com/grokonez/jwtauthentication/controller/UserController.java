package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.security.services.UserPrinciple;
import com.grokonez.jwtauthentication.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/active")
    public List<User> getUserByDateStage(){ return userService.getUserByDateStage();}

}
