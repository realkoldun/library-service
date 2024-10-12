package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void addBook(Book book);
}

