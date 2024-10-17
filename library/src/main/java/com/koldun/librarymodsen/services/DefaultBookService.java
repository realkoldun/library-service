package com.koldun.librarymodsen.services;

import com.koldun.librarymodsen.controller.book.BookRequest;
import com.koldun.librarymodsen.interfaces.book.BookToDtoMapper;
import com.koldun.librarymodsen.interfaces.book.BookToEntityMapper;
import com.koldun.librarymodsen.model.Book;
import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.interfaces.book.BookRepository;
import com.koldun.librarymodsen.interfaces.book.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;
    private final BookToDtoMapper dtoMapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found: id = " + id));
        return mapper.bookEntityToBook(bookEntity);
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
    public void addBook(BookRequest bookRequest) {
        Book book = dtoMapper.AddBookRequestToBook(bookRequest);
        bookRepository.save(mapper.bookToBookEntity(book));
    }

    @Override
    public Book getBookByISBN(Long isbn) {
        BookEntity bookEntity = bookRepository
                .findByISBN(isbn);
        if (bookEntity == null) throw new EntityNotFoundException("Book not found: ISBN = " + isbn);
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public Book updateBook(Long id, BookRequest book) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found: id = " + id));
        bookEntity.setISBN(book.getISBN());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setGenre(book.getGenre());
        bookEntity.setTitle(book.getTitle());

        return mapper.bookEntityToBook(bookRepository.save(bookEntity));
    }
}
