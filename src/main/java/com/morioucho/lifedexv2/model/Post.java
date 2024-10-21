package com.morioucho.lifedexv2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Embedded;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private ViewStatistic viewStatistic;

    private String title;
    private String content;

    private String authorFirst;
    private String authorLast;

    private LocalDateTime creationDate;
    private LocalDateTime lastModified;

    public void view(){
        this.viewStatistic.view();
    }
}
