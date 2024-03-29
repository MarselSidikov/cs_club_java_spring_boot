package ru.cs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cs.models.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeBefore(Integer value);
    List<User> findAllByHeightAndAgeBetweenOrderById(Double height, Integer before, Integer after);
}
