package com.example.zagirox.biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
