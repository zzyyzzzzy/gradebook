package dev.daycareworkers.controllers;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.dtos.Token;
import dev.daycareworkers.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Token login(@RequestBody LoginCredentials loginCredentials) {
        Date currentTime = new Date(System.currentTimeMillis());
        String message = "User " + loginCredentials.getUsername() + "logged in. Time: " + currentTime.toString();
        jmsTemplate.convertAndSend("important-event-queue", message);

        return loginService.authenticateUser(loginCredentials);
    }
}
