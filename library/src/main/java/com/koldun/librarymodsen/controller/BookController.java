package com.koldun.librarymodsen.controller;

import com.koldun.librarymodsen.interfaces.BookService;
import com.koldun.librarymodsen.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/isbn/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn) {
        return bookService.getBookByISBN(Long.parseLong(isbn));
    }
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @PostMapping
    public void createBook(@RequestBody BookRequest request) {
        System.out.println(request.toString());
        bookService.addBook(request);
    }
}
