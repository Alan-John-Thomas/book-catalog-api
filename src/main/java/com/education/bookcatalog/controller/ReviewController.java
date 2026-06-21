package com.education.bookcatalog.controller;

import com.education.bookcatalog.model.Book;
import com.education.bookcatalog.model.Review;
import com.education.bookcatalog.repository.BookRepository;
import com.education.bookcatalog.repository.ReviewRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/books/{bookId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@PathVariable Long bookId, @Valid @RequestBody Review review){ // the review body(json) has null for bookId row as book id is mentioned in the request itself.
        Book b = bookRepository.findById(bookId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found"));
        review.setBook(b);// sets the null to a valid book
        return reviewRepository.save(review);
    }
}
