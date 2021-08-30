package com.grokonez.jwtauthentication.security.services;

import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grokonez.jwtauthentication.model.RoleName ;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByDateStage() { return userRepository.getUserByDateStage();
    }
    public List<User>getByRoles_Name() { return userRepository.findByRoles_Name(RoleName.ROLE_USER);}

}
