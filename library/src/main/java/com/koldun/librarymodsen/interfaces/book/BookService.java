package com.koldun.librarymodsen.interfaces.book;

import com.koldun.librarymodsen.controller.book.BookRequest;
import com.koldun.librarymodsen.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void addBook(BookRequest book);
    Book getBookByISBN(String isbn);
    Book updateBook(Long id, BookRequest book);
    Book deleteBook(Long id);
    List<Book> getFreeBooks();
}

