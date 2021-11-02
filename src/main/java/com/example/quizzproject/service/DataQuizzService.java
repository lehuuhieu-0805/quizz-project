package com.example.quizzproject.service;

import com.example.quizzproject.model.DataQuizz;

import java.util.List;

public interface DataQuizzService {
    public List<DataQuizz> getAll();
    public DataQuizz saveData(DataQuizz dataQuizz);
}
