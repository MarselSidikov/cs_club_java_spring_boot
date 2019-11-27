package ru.cs.spring.boot.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cs.spring.boot.demo.services.ConfirmService;

@Controller
@RequestMapping("/confirm")
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @PreAuthorize("permitAll()")
    @GetMapping("/{confirm-link}")
    public String getConfirmPage(@PathVariable("confirm-link") String confrimLink) {
        boolean confrimed = confirmService.isConfirmed(confrimLink);
        if (confrimed) {
            return "success";
        } else {
            return "notSuccess";
        }
    }

}
