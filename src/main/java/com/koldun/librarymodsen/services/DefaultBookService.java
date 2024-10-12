package com.koldun.librarymodsen.services;

import com.koldun.librarymodsen.interfaces.BookToEntityMapper;
import com.koldun.librarymodsen.model.Book;
import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.exceptions.BookNotFoundException;
import com.koldun.librarymodsen.interfaces.BookRepository;
import com.koldun.librarymodsen.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: ISBN = " + id));
        return new Book(bookEntity.getISBN(),
                bookEntity.getTitle(),
                bookEntity.getGenre(),
                bookEntity.getDescription(),
                bookEntity.getAuthor());
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> bookEntities = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            books.add(mapper.bookEntityToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }
}
