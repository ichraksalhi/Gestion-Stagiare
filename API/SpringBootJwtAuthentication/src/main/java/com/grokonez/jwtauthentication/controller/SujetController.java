package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Sujet;
import com.grokonez.jwtauthentication.service.SujetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/sujets")
public class SujetController
{
    private final SujetService sujetService;

    public SujetController(SujetService sujetService) {
        this.sujetService = sujetService;
    }


    @PostMapping("/add")
    public ResponseEntity<Sujet> addSujet(@RequestBody Sujet sujet){
        Sujet newSujet=sujetService.addSujet(sujet);
        return new ResponseEntity<>(newSujet, HttpStatus.CREATED);
    }
}