package ru.cs.spring.boot.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cs.spring.boot.demo.forms.AuthUserForm;
import ru.cs.spring.boot.demo.services.SignUpService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService service;

    @PreAuthorize("permitAll()")
    @GetMapping
    public String getSignUpPage() {
        return "signUp";
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public String signUpUser(AuthUserForm form) {
        service.signUpUser(form);
        // redirect отправить в заголовках ответа
        // header -> location:signIn
        return "redirect:/signIn";
    }
}
