package com.example.quizzproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CoursesQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public CoursesQuiz() {
    }

    public CoursesQuiz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
