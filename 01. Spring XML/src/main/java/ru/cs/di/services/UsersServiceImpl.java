package ru.cs.di.services;

import ru.cs.di.models.User;
import ru.cs.di.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(String firstName, String lastName) {
        User user = User.builder()
                .name(firstName + " " + lastName)
                .build();

        usersRepository.save(user);
    }
}
