package ru.cs.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.cs.di.config.AppConfig;
import ru.cs.di.services.UsersService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UsersService usersService = context.getBean("usersService", UsersService.class);
        usersService.signUp("Булат", "Гимазов");
    }
}
