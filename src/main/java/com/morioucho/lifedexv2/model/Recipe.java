package com.morioucho.lifedexv2.model;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Recipe extends Post {
    private String steps;
    private int cookTime;
    private int calories;
    private String cuisine;
    private int yield;

}
