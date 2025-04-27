package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.*;

public interface BookService {
    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    BookDto getByNameV3(String name);

    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    default void deleteBook(Long id) {
    }
}

