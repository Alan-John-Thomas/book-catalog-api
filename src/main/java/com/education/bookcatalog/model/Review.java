package com.education.bookcatalog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String reviewerName;
    @Min(value = 1,message = "rating must be at least 1")
    @Max(value = 5, message = "maximum rating allowed is 5")
    private Integer rating;
    private String comment;

    @ManyToOne
    // creates a foreign key column named bookId whose values is check with Book(as Book book) is annotated tables primary key by default.
    @JoinColumn(name = "book_id",nullable = false) // use referencedColumnName to check the entry in bookId with other rows like ISBN,author etc. in Book table than the default primary key.
    private Book book;
}
