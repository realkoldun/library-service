package com.koldun.librarymodsen.model;

public record Book(Long id,
                   Long ISBN,
                   String title,
                   String genre,
                   String description,
                   String author) {
}
