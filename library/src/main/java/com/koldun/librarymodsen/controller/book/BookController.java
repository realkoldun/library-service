package com.koldun.librarymodsen.controller.book;

import com.koldun.librarymodsen.interfaces.book.BookRepository;
import com.koldun.librarymodsen.interfaces.book.BookService;
import com.koldun.librarymodsen.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        Book updatedBook = bookService.updateBook(id, bookRequest);
        return ResponseEntity.ok(updatedBook);
    }
    @PostMapping
    public void createBook(@RequestBody BookRequest bookRequest) {
        //System.out.println(bookRequest.toString());
        bookService.addBook(bookRequest);
    }
}
