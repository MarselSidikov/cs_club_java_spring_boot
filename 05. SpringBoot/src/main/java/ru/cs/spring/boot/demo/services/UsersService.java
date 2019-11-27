package ru.cs.spring.boot.demo.services;

import ru.cs.spring.boot.demo.models.User;

import java.util.List;

public interface UsersService {
    List<User> getUsers();
}
