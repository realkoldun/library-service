package com.koldun.librarymodsen.services;

import com.koldun.librarymodsen.controller.book.BookRequest;
import com.koldun.librarymodsen.entities.TicketEntity;
import com.koldun.librarymodsen.interfaces.book.BookToDtoMapper;
import com.koldun.librarymodsen.interfaces.book.BookToEntityMapper;
import com.koldun.librarymodsen.interfaces.ticket.TicketRepository;
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
    private final TicketRepository ticketRepository;

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
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
        ticketRepository.save(new TicketEntity(null, bookEntity, null, null));

    }

    @Override
    public Book getBookByISBN(String isbn) {
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
    @Override
    public Book deleteBook(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found: id = " + id));
        try {
            ticketRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error in deleting ticket: " + e.getMessage());
        }
        bookRepository.deleteById(id);
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getFreeBooks() {
        Iterable<BookEntity> bookEntities = bookRepository.findBooksWithoutDates();
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            books.add(mapper.bookEntityToBook(bookEntity));
        }
        return books;
        //return bookRepository.findBooksWithoutDates();
        //return List.of();
    }
}
