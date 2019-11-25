package ru.cs.di.repositories;

import lombok.SneakyThrows;
import ru.cs.di.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.UUID;

public class UsersRepositoryFilesBasedImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryFilesBasedImpl(String fileName) {
        this.fileName = fileName;
    }

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
