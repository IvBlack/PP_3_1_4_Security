package ru.kata.spring.boot_security.demo.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //через атрибуты модели  -> в представление
    //имя авторизованного юзера из объекта Principal
    @GetMapping("")
    public String showAuthUserPage(@NotNull Model mod, Authentication auth) {
        mod.addAttribute("sessionUser", userService.getByUserName(auth.getName()));
        return "user";
    }
}
