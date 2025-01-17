package com.example.zagirox.biblioteca.repositories;

import com.example.zagirox.biblioteca.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearLessThanAndDeathYearIsNull(int year);
}
