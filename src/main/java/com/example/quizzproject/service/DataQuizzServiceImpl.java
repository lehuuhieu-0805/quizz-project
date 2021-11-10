package com.example.quizzproject.service;

import com.example.quizzproject.model.DataQuiz;
import com.example.quizzproject.repository.DataQuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataQuizzServiceImpl implements DataQuizzService {
    @Autowired
    private DataQuizzRepository dataQuizzRepository;

    @Override
    public List<DataQuiz> getAllQuestion() {
        return dataQuizzRepository.findAll();
    }

    @Override
    public DataQuiz saveQuestion(DataQuiz dataQuiz) {
        return dataQuizzRepository.save(dataQuiz);
    }

    @Override
    public void removeQuestion(int id) {
        dataQuizzRepository.deleteById(id);
    }
    @Override
    public Optional<DataQuiz> getQuestionById(int id){
        return dataQuizzRepository.findById(id);
    }
}
