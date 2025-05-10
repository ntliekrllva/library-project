package ru.itgirl.library_project.service;

import ru.itgirl.library_project.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    void save(User user);
}
