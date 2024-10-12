package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity book);
}
