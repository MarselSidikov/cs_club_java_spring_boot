package ru.cs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.cs.hibernate.models.Car;
import ru.cs.hibernate.models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // альтернатива hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cs_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "qwerty007");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addResource("User.hbm.xml");
        configuration.addResource("Car.hbm.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
//      session.save(User.builder().name("Bulat").build());
        User user = session.createQuery("from User user where user.id = ?1",
                User.class).setParameter(1, 3L).getSingleResult();
//        Car car = Car.builder()
//                .model("Logan Черного цвета 20-го века")
//                .owner(user)
//                .build();
//        session.save(car);
//        user = session.createQuery("from User user where user.id = ?1",
//                User.class).setParameter(1, 1L).getSingleResult();
        System.out.println(user);
        //        System.out.println(user);
//        List<User> users = session.createQuery("from User", User.class).getResultList();
    }
}
