package com.example.quizzproject.repository;

import com.example.quizzproject.model.DataQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataQuizzRepository extends JpaRepository<DataQuiz, Integer> {
}
