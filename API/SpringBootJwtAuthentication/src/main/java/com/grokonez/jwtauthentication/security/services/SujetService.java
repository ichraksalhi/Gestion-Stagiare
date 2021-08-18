package com.grokonez.jwtauthentication.service;

import com.grokonez.jwtauthentication.model.Sujet;
import com.grokonez.jwtauthentication.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SujetService {

    @Autowired
    SujetRepository sujetRepo;

    public Sujet addSujet(Sujet sujet){
        return sujetRepo.save(sujet);
    }
}