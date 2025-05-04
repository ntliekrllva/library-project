package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.*;
import ru.itgirl.library_project.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public interface BookService {
    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    BookDto getByNameV3(String name);

    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    List<BookDto> getAllBooks();

    default void deleteBook(Long id) {

    }
}

