package com.koldun.librarymodsen.model;

import lombok.Value;

@Value
public class Book {
    Long ISBN;
    String title;
    String genre;
    String description;
    String author;
}
