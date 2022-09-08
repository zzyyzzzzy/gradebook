package dev.daycareworkers.services;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.dtos.Token;

public interface LoginService {

    Token authenticateUser(LoginCredentials loginCredentials);
}
