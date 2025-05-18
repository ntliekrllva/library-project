package ru.itgirl.library_project.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.AuthorUpdateDto;
import ru.itgirl.library_project.service.AuthorService;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "library-users")
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByName(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByNameV1(name);
    }

    @GetMapping("/author/v2")
    AuthorDto getAuthorByNameV2(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByNameV2(name);
    }

    @GetMapping("/author/v3")
    AuthorDto getAuthorByNameV3(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByNameV3(name);
    }

    @PostMapping("/author/create")
    AuthorDto createAuthor(@RequestBody @Valid AuthorCreateDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto);
    }

    @PutMapping("/author/update")
    AuthorDto updateAuthor(@RequestBody @Valid AuthorUpdateDto authorUpdateDto) {
        return authorService.updateAuthor(authorUpdateDto);
    }

    @DeleteMapping("/author/delete/{id}")
    void updateAuthor(@PathVariable ("id") Long id) {
        authorService.deleteAuthor(id);
    }
}