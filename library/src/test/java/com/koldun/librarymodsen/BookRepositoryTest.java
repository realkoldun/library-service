package com.koldun.librarymodsen;

import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.interfaces.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindBooksWithoutDates() {
        /*BookEntity book1 = new BookEntity();
        book1.setISBN("ISBN1");
        book1.setAuthor("Author1");
        book1.setDescription("Description1");
        book1.setGenre("Genre1");
        book1.setTitle("Title1");

        BookEntity book2 = new BookEntity();
        book2.setISBN("ISBN2");
        book2.setAuthor("Author2");
        book2.setDescription("Description2");
        book2.setGenre("Genre2");
        book2.setTitle("Title2");

        bookRepository.save(book1);
        bookRepository.save(book2);

        List<BookEntity> books = bookRepository.findBooksWithoutDates();
        assertThat(books).hasSize(2);*/
    }
}
