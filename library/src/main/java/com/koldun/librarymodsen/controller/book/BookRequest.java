package com.koldun.librarymodsen.controller.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRequest {
    private Long ISBN;
    private String title;
    private String genre;
    private String description;
    private String author;

    @Override
    public String toString() {
        return "BookRequest{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
