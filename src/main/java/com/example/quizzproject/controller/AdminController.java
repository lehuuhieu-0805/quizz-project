package com.example.quizzproject.controller;

import com.example.quizzproject.model.CoursesQuiz;
import com.example.quizzproject.model.DataQuiz;
import com.example.quizzproject.service.CoursesQuizService;
import com.example.quizzproject.service.DataQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private DataQuizzService dataQuizzService;
    @Autowired
    private CoursesQuizService coursesQuizService;

    @PostMapping("/addcourse")
    public String addCourses(@RequestBody CoursesQuiz coursesQuiz) {
        coursesQuizService.saveCourses(coursesQuiz);
        return "new course is added";
    }

    @GetMapping("/course")
    public List<CoursesQuiz> getAllCourse() {
        return coursesQuizService.getAllCourses();
    }

    @GetMapping("/deletecourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        coursesQuizService.removeCourses(id);
        return "course is deleted";
    }

    @PutMapping("/updatecourse/{id}")
    public String updateCourse(@RequestBody CoursesQuiz coursesQuiz) {
        coursesQuizService.saveCourses(coursesQuiz);
        return "course is updated";
    }

    @PostMapping("/add")
    public String add(@RequestBody DataQuiz dataQuiz) {
        dataQuizzService.saveData(dataQuiz);
        return "new question is added";
    }

    @GetMapping("/quizz")
    public List<DataQuiz> getAll() {
        return dataQuizzService.getAll();
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        dataQuizzService.removeQuestion(id);
        return "question is deleted";
    }

    @PutMapping("/update/{id}")
    public String updateQuestion(@RequestBody DataQuiz dataQuiz) {
        dataQuizzService.saveData(dataQuiz);
        return "question is updated";
    }

}
