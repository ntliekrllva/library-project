package ru.itgirl.library_project.service;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Book;
import ru.itgirl.library_project.repository.AuthorRepository;

@SpringBootTest
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void testGetAuthorById() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        Author author = new Author(id, name, surname, books);

        when(authorRepository.findById(id)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorById(id);

        verify(authorRepository).findById(id);
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorByIdNotFound() {
        Long id = 1L;
        when(authorRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalStateException.class, () -> authorService.getAuthorById(id));

        verify(authorRepository).findById(id);
    }

    @Test
    public void testGetAuthorByNameV1() {
        String name = "John";
        Long id = 1L;
        String surname = "Doe";

        Author author = new Author(id, name, surname, new HashSet<>());
        when(authorRepository.findAuthorByName(name)).thenReturn(Optional.of(author));

        AuthorDto result = authorService.getAuthorByNameV1(name);

        verify(authorRepository).findAuthorByName(name);

        Assertions.assertEquals(id, result.getId());
        Assertions.assertEquals(name, result.getName());
        Assertions.assertEquals(surname, result.getSurname());
    }

    @Test
    public void testGetAuthorByNameV1NotFound() {
        String name = "John";
        when(authorRepository.findAuthorByName(name)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.getAuthorByNameV1(name));

        verify(authorRepository).findAuthorByName(name);
    }
}