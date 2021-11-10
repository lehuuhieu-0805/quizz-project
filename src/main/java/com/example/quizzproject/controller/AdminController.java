package com.example.quizzproject.controller;

import com.example.quizzproject.model.CoursesQuiz;
import com.example.quizzproject.model.DataQuiz;
import com.example.quizzproject.service.CoursesQuizService;
import com.example.quizzproject.service.DataQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private DataQuizzService dataQuizzService;
    @Autowired
    private CoursesQuizService coursesQuizService;

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourses(@RequestBody CoursesQuiz coursesQuiz) {
        return new ResponseEntity<>(coursesQuizService.saveCourses(coursesQuiz), HttpStatus.CREATED);
    }

    @GetMapping("/course")
    public List<CoursesQuiz> getAllCourse() {
        return coursesQuizService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Optional<CoursesQuiz> getCourseById(@PathVariable int id){
        return coursesQuizService.getCoursesById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        coursesQuizService.removeCourses(id);
        return "course id : " + id + " is deleted";
    }

    @PutMapping("/updateCourse/{id}")
    public CoursesQuiz updateCourse(@PathVariable int id,@RequestBody CoursesQuiz coursesQuiz) {
        return coursesQuizService.saveCourses(coursesQuiz);
    }

    @GetMapping("/question")
    public List<DataQuiz> getAllQuestion() {
        return dataQuizzService.getAllQuestion();
    }

    @GetMapping("/question/{id}")
    public Optional<DataQuiz> getQuestionById(@PathVariable int id){
        return dataQuizzService.getQuestionById(id);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<?> add(@RequestBody DataQuiz dataQuiz) {
        return new ResponseEntity<>(dataQuizzService.saveQuestion(dataQuiz), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id) {
        dataQuizzService.removeQuestion(id);
        return "question id : " + id + " is deleted";
    }

    @PutMapping("/updateQuestion/{id}")
    public DataQuiz updateQuestion(@PathVariable int id, @RequestBody DataQuiz dataQuiz) {
        return dataQuizzService.saveQuestion(dataQuiz);
    }

}
