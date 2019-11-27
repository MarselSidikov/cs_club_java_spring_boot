package ru.cs.jpa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.cs.jpa.models.User;
import ru.cs.jpa.models.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

public class Main {
    public static void main(String[] args) {
        // альтернатива hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cs_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "qwerty007");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Car.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(User.builder().name("Марсель").build());
        transaction.commit();

    }
}
