package com.koldun.librarymodsen.interfaces.book;

import com.koldun.librarymodsen.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    BookEntity findByISBN(Long ISBN);
}

