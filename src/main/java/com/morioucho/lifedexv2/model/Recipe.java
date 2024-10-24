package com.morioucho.lifedexv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255)
    private String authorFirst;

    @Column(length = 255)
    private String authorLast;

    private int calories;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String cookTime;

    private LocalDateTime creationDate;

    @Column(length = 255)
    private String cuisine;

    private LocalDateTime lastModified;

    @Column(columnDefinition = "TEXT")
    private String steps;

    @Column(length = 255)
    private String title;

    private int yield;
}
