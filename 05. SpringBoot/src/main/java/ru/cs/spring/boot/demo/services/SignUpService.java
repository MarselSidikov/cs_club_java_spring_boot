package ru.cs.spring.boot.demo.services;

import ru.cs.spring.boot.demo.forms.AuthUserForm;

public interface SignUpService {
    void signUpUser(AuthUserForm form);
}
