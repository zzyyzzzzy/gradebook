package dev.daycareworkers.controllers;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.dtos.Token;
import dev.daycareworkers.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login") // use someone's credentials to generate a custom JWT for them
    public Token login(@RequestBody LoginCredentials loginCredentials) {
        System.out.println("inside controller" + loginCredentials);
        return loginService.authenticateUser(loginCredentials);
    }
}