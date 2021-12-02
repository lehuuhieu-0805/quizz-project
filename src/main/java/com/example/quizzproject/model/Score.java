package com.example.quizzproject.model;

import javax.persistence.*;
@Entity
@Table(name = "tblScore")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float score;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "Courses_Id")
    private CoursesQuiz coursesQuiz;

    public Score() {
    }

    public Score(int id, float score, User user, CoursesQuiz coursesQuiz) {
        this.id = id;
        this.score = score;
        this.user = user;
        this.coursesQuiz = coursesQuiz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoursesQuiz getCoursesQuiz() {
        return coursesQuiz;
    }

    public void setCoursesQuiz(CoursesQuiz coursesQuiz) {
        this.coursesQuiz = coursesQuiz;
    }
}
