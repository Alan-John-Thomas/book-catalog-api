package com.education.bookcatalog.controller;

import com.education.bookcatalog.model.Book;
import com.education.bookcatalog.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}
