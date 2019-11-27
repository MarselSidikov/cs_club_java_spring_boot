package ru.cs.spring.boot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cs.spring.boot.demo.models.User;
import ru.cs.spring.boot.demo.models.UserState;
import ru.cs.spring.boot.demo.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean isConfirmed(String confirmLink) {
        Optional<User> userOptional = usersRepository.findByConfirmLink(confirmLink);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setState(UserState.CONFIRMED);
            usersRepository.save(user);
            return true;
        }
        return false;
    }
}
