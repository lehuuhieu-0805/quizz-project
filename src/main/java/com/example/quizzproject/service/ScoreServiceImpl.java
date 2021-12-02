package com.example.quizzproject.service;

import com.example.quizzproject.model.Score;
import com.example.quizzproject.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepository;
    @Override
    public Score saveScore(Score score){
        return scoreRepository.save(score);
    }
    @Override
    public List<Score> getScoreByUserId(int id){
        return scoreRepository.getScoreByUserId(id);
    }
}
