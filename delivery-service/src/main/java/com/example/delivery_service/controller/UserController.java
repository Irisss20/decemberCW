package com.example.delivery_service.controller;

import com.example.delivery_service.dto.UserDto;
import com.example.delivery_service.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Validated
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Примитивная регистрация (возвращает UserDto без пароля)
     */
    @PostMapping("/register")
    public UserDto register(@RequestParam @Email String email,
                            @RequestParam @NotBlank String name,
                            @RequestParam @NotBlank String phone,
                            @RequestParam @NotBlank String password) {
        return userService.register(email, name, phone, password);
    }
}
