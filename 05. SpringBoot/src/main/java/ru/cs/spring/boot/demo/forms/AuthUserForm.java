package ru.cs.spring.boot.demo.forms;

import lombok.Data;

@Data
public class AuthUserForm {
    private String email;
    private String password;
}
