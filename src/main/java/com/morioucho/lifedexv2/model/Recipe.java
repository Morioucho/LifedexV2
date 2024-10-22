package com.morioucho.lifedexv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private ViewStatistic viewStatistic;

    @ElementCollection
    private List<String> ingredients;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String authorFirst;
    private String authorLast;

    private LocalDateTime creationDate;
    private LocalDateTime lastModified;

    private String steps;
    private int cookTime;
    private int calories;
    private String cuisine;
    private int yield;

    public void view(){
        this.viewStatistic.view();
    }
}
