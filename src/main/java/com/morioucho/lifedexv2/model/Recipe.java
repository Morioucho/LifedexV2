package com.morioucho.lifedexv2.model;

import jakarta.persistence.*;
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

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String authorFirst;

    @Column(length = 255)
    private String authorLast;

    @Column(length = 500)
    private String imageURL;
    private String imageCaption;

    private LocalDateTime creationDate;
    private LocalDateTime lastModified;

    @Column(columnDefinition = "TEXT")
    private String steps;

    private int cookTime;
    private int calories;

    @Column(length = 255)
    private String cuisine;

    private int yield;

    @ElementCollection
    private List<String> ingredients;
}
