package com.example.quizzproject.repository;

import com.example.quizzproject.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> getScoreByUserId(int id);
}
