package ru.cs.spring.boot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cs.spring.boot.demo.models.User;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmLink(String confirmLink);
}
