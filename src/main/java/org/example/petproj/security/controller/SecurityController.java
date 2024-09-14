package org.example.petproj.security.controller;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.petproj.security.entity.Role;
import org.example.petproj.security.entity.UserDets;
import org.example.petproj.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class SecurityController {

    private Map<Role, String> roles;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "security/login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        roles  = new HashMap<>();
        roles.put(Role.ROLE_CHEESE_PRODUCER, "Сыровар");
        roles.put(Role.ROLE_STORAGE_WORKER, "Работник склада");
        roles.put(Role.ROLE_SELLER, "Работник отдела продаж");
        model.addAttribute("user", new UserDets());
        model.addAttribute("rolesMap", roles);
        return "security/registration";
    }


    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute(name = "user") UserDets user, Model model){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserDets>> violations = validator.validate(user);

        if(!violations.isEmpty() || userService.findAllByPhoneNumber(user.getPhoneNumber()) != null){
            model.addAttribute("user", new UserDets());
            model.addAttribute("rolesMap", roles);
            return "security/registration";
        }
        userService.createUser(user);
        factory.close();
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/login";
    }
}
