package com.koldun.librarymodsen.controller.book;

import com.koldun.librarymodsen.interfaces.book.BookService;
import com.koldun.librarymodsen.model.Book;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name="Book Controller", description = "How to interact with books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/isbn/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn) {
        return bookService.getBookByISBN(isbn);
    }
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/free")
    public List<Book> getFreeBooks() {
        return bookService.getFreeBooks();
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        Book updatedBook = bookService.updateBook(id, bookRequest);
        return ResponseEntity.ok(updatedBook);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book deletedBook = bookService.deleteBook(id);
        return ResponseEntity.ok(deletedBook);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookRequest bookRequest) {
        bookService.addBook(bookRequest);
    }
}
