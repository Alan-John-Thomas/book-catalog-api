package com.education.bookcatalog.controller;

import com.education.bookcatalog.model.Book;
import com.education.bookcatalog.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor

public class BookController {
    private final BookRepository bookRepository;
    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
