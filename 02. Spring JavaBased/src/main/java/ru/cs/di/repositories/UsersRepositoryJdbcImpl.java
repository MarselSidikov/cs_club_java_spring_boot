package ru.cs.di.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.cs.di.models.User;

import java.util.HashMap;
import java.util.Map;

@Component(value = "usersRepositoryJdbcImpl")
public class UsersRepositoryJdbcImpl implements UsersRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public UsersRepositoryJdbcImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //language=SQL
    private static final String SQL_INSERT = "insert into cs_user (name) values (:name);";

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
