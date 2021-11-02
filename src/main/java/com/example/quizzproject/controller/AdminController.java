package com.example.quizzproject.controller;

import com.example.quizzproject.model.DataQuizz;
import com.example.quizzproject.service.DataQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
@CrossOrigin
public class AdminController {
    @Autowired
    private DataQuizzService dataQuizzService;

    @PostMapping("/add")
    public String add(@RequestBody DataQuizz dataQuizz) {
        dataQuizzService.saveData(dataQuizz);
        return "new question is added";
    }
    @GetMapping("/quizz")
    public List<DataQuizz> getAll() {
        return dataQuizzService.getAll();
    }
}
