package com.education.bookcatalog.controller;

import com.education.bookcatalog.model.Book;
import com.education.bookcatalog.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

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
    public Book createBook(@RequestBody @Valid Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @PutMapping("/{id}")
    public Book putBook(@PathVariable Long id,@RequestBody @Valid Book bookDetails){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setIsbn(bookDetails.getIsbn());
        existingBook.setPublishedYear(bookDetails.getPublishedYear());
        existingBook.setTitle(bookDetails.getTitle());

        return bookRepository.save(existingBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        if(!bookRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found");
        }
        bookRepository.deleteById(id);
    }
}
