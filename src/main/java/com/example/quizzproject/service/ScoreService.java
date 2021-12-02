package com.example.quizzproject.service;

import com.example.quizzproject.model.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreService {
    public Score saveScore(Score score);
    public List<Score> getScoreByUserId(int id);
}
