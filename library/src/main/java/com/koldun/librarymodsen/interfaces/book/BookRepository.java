package com.koldun.librarymodsen.interfaces.book;

import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    BookEntity findByISBN(String ISBN);
    void deleteById(Long id);
    @Query("SELECT b FROM BookEntity b WHERE b.id NOT IN (SELECT t.book.id FROM TicketEntity t WHERE t.takenDate IS NOT NULL AND t.returnDate IS NOT NULL)")
    List<BookEntity> findBooksWithoutDates();
}

