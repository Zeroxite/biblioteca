package com.example.zagirox.biblioteca.services;

import com.example.zagirox.biblioteca.models.Book;

import java.util.List;

public class BookResponse {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
