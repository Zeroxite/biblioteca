package com.example.zagirox.biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String language;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}