package ru.cs.di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.cs.di.models.User;
import ru.cs.di.repositories.UsersRepository;

@Component("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    @Qualifier("usersRepositoryJdbcImpl")
    private UsersRepository usersRepository;

    @Override
    public void signUp(String firstName, String lastName) {
        User user = User.builder()
                .name(firstName + " " + lastName)
                .build();

        usersRepository.save(user);
    }
}
