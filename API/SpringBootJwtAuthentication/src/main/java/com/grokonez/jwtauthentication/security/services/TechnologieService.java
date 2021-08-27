package com.grokonez.jwtauthentication.security.services;

import com.grokonez.jwtauthentication.model.Technologie;
import com.grokonez.jwtauthentication.repository.SujetRepository;
import com.grokonez.jwtauthentication.repository.Technologierepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologieService {

    @Autowired
    Technologierepository technologieRepo;
    public List<Technologie> getTechno() {return (List<Technologie>)technologieRepo.findAll();}
}
