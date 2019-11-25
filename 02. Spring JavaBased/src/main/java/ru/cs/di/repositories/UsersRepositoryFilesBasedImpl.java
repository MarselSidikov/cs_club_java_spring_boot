package ru.cs.di.repositories;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.cs.di.models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;

@Component(value = "usersRepositoryFilesBasedImpl")
public class UsersRepositoryFilesBasedImpl implements UsersRepository {

    @Value("${users.filename}")
    private String fileName;

    // TODO: FIX
    @SneakyThrows
    public void save(User model) {
        BufferedWriter writer =
                new BufferedWriter(new FileWriter(fileName, true));

        writer.write(777 + " " + model.getName() + "\n");
        writer.close();
    }

    public User findById(Long aLong) {
        return null;
    }
}
