package com.example.zagirox.biblioteca.services;

import com.example.zagirox.biblioteca.repositories.AuthorRepository;
import com.example.zagirox.biblioteca.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.zagirox.biblioteca.models.Book;
import com.example.zagirox.biblioteca.models.Author;

import java.util.List;

@Service
public class BookService {

    private final RestTemplate restTemplate;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(RestTemplate restTemplate, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void searchBookByTitle(String title) {
        String apiUrl = "https://api.gutandex.com/books?title=" + title;
        BookResponse response = restTemplate.getForObject(apiUrl, BookResponse.class);

        if (response != null && response.getBooks() != null) {
            response.getBooks().forEach(book -> {
                bookRepository.save(book);
                System.out.println("Guardado: " + book);
            });
        } else {
            System.out.println("No se encontraron libros.");
        }
    }

    public void listAllBooks() {
        List<Book> books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    public void listAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    public void listLivingAuthorsByYear(int year) {
        List<Author> authors = authorRepository.findByBirthYearLessThanAndDeathYearIsNull(year);
        authors.forEach(System.out::println);
    }

    public void listBooksByLanguage(String language) {
        List<Book> books = bookRepository.findByLanguage(language);
        books.forEach(System.out::println);
    }
}

