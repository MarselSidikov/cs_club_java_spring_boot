package ru.cs.di.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.cs.di.models.User;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private NamedParameterJdbcTemplate template;

    //language=SQL
    private static final String SQL_INSERT = "insert into cs_user (name) values (:name);";

    public UsersRepositoryJdbcImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void save(User model) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", model.getName());
        template.update(SQL_INSERT, params);
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }
}
