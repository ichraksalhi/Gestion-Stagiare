package com.grokonez.jwtauthentication.security.services;

import com.grokonez.jwtauthentication.model.Stage;
import com.grokonez.jwtauthentication.model.Sujet;
import com.grokonez.jwtauthentication.model.Technologie;
import com.grokonez.jwtauthentication.repository.StageRepository;
import com.grokonez.jwtauthentication.repository.Technologierepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {


    @Autowired
    StageRepository stageRepository;

    public List<Stage> getStage() {return (List<Stage>)stageRepository.findAll();}

    public Stage addStage(Stage stage){
        return stageRepository.save(stage);
    }

}
