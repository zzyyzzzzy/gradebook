package dev.daycareworkers.services;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.entities.Token;

public interface LoginService {

    Token authenticateUser(LoginCredentials loginCredentials);
}
