package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.controller.BookRequest;
import com.koldun.librarymodsen.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book AddBookRequestToBook(BookRequest book);
}
