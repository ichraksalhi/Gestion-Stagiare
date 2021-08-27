package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Stage;
import com.grokonez.jwtauthentication.model.Sujet;
import com.grokonez.jwtauthentication.model.Technologie;
import com.grokonez.jwtauthentication.security.services.StageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping("/all")
    public List<Stage> getStage(){
        return stageService.getStage();
    }

    @PostMapping("/add")
        public ResponseEntity<Stage> addStage(@RequestBody Stage stage){
            Stage newStage=stageService.addStage(stage);
            return new ResponseEntity<>(newStage, HttpStatus.CREATED);
        }

}
