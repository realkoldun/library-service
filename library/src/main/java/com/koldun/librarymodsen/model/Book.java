package com.koldun.librarymodsen.model;

public record Book(Long id,
                   String ISBN,
                   String title,
                   String genre,
                   String description,
                   String author) {
}
