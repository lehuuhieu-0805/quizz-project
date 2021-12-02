package com.example.quizzproject.controller;

import com.example.quizzproject.model.Score;
import com.example.quizzproject.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @PostMapping("/saveScore")
    public ResponseEntity<?> saveScore(@RequestBody Score score){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        String dateFormat = formatter.format(date);
        score.setTimeSubmit(dateFormat);
        System.out.println(score);
        return new ResponseEntity<>(scoreService.saveScore(score), HttpStatus.CREATED);
    }
    @GetMapping("/score/{id}")
    public ResponseEntity<?> getScoreByUserId(@PathVariable int id){
         List<Score> score = scoreService.getScoreByUserId(id);
        if(score.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        return ResponseEntity.ok(score);
    }
}
