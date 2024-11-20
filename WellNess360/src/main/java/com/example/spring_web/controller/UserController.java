package com.example.spring_web.controller;



import com.example.spring_web.model.Users;
import com.example.spring_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    //USER_REGISTRATION
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }
}