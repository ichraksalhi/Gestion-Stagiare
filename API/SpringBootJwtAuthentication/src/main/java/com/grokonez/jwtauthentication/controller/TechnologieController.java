package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Technologie;
import com.grokonez.jwtauthentication.security.services.TechnologieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/technologies")
public class TechnologieController {

    private final TechnologieService technologieService;

    public TechnologieController(TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @GetMapping("/all")
    public List<Technologie> getTechno(){
        return technologieService.getTechno();
    }
}
