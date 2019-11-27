package ru.cs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.cs.config.SpringDataJpaConfig;
import ru.cs.models.User;
import ru.cs.repositories.UsersRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);
        UsersRepository usersRepository = context.getBean(UsersRepository.class);
//        usersRepository.save(User.builder().name("Марсель").build());
//        usersRepository.save(User.builder().name("Булат").build());
//        usersRepository.save(User.builder().name("Дмитрий").build());
        List<User> users = usersRepository.findAllByAgeBefore(25);
        System.out.println(users);
        users = usersRepository. findAllByHeightAndAgeBetweenOrderById(1.86, 15, 19);
        System.out.println(users);


    }
}
