package com.education.bookcatalog.model;

// 1. Lombok Imports

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 2. JPA (Persistence) Imports

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @Column(unique = true)
    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;
    @Min(value = 1000, message = "Published year must be at least 1000")
    @Max(value = 2026, message = "Published year cannot be in the future")
    private Integer publishedYear;
}
