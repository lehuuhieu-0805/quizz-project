package com.example.quizzproject.model;

import javax.persistence.*;

@Entity
public class DataQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correct_Answer;
    private float point;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Courses_Quiz", referencedColumnName = "id")
    private CoursesQuiz id_Courses_Quiz;

    public DataQuiz() {
    }

    public DataQuiz(int id, String question, String answerA, String answerB, String answerC, String answerD, String correct_Answer, float point, CoursesQuiz id_Courses_Quiz) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct_Answer = correct_Answer;
        this.point = point;
        this.id_Courses_Quiz = id_Courses_Quiz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrect_Answer() {
        return correct_Answer;
    }

    public void setCorrect_Answer(String correct_Answer) {
        this.correct_Answer = correct_Answer;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public CoursesQuiz getId_Courses_Quiz() {
        return id_Courses_Quiz;
    }

    public void setId_Courses_Quiz(CoursesQuiz id_Courses_Quiz) {
        this.id_Courses_Quiz = id_Courses_Quiz;
    }
}



