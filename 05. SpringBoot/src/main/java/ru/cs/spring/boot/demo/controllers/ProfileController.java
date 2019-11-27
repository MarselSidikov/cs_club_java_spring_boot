package ru.cs.spring.boot.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cs.spring.boot.demo.security.details.UserDetailsImpl;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 Model model) {
        model.addAttribute("user", userDetails.getUser());
        return "profile";
    }
}
