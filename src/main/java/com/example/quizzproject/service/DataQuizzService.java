package com.example.quizzproject.service;

import com.example.quizzproject.model.DataQuiz;

import java.util.List;
import java.util.Optional;

public interface DataQuizzService {
    public List<DataQuiz> getAll();
    public DataQuiz saveData(DataQuiz dataQuiz);
    public void removeQuestion(int id);
    public Optional<DataQuiz> getQuestionById(int id);
}
