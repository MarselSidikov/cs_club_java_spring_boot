package ru.cs.spring.boot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cs.spring.boot.demo.models.User;
import ru.cs.spring.boot.demo.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }
}
