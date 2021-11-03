package com.example.quizzproject.service;

import com.example.quizzproject.model.DataQuizz;
import com.example.quizzproject.repository.DataQuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataQuizzServiceImpl implements DataQuizzService {
    @Autowired
    private DataQuizzRepository dataQuizzRepository;

    @Override
    public List<DataQuizz> getAll() {
        return dataQuizzRepository.findAll();
    }

    @Override
    public DataQuizz saveData(DataQuizz dataQuizz) {
        return dataQuizzRepository.save(dataQuizz);
    }
}
