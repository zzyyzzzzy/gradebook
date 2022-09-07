package dev.daycareworkers.services;

import dev.daycareworkers.dtos.LoginCredentials;

public interface LoginService {

    public String authenticateUser(LoginCredentials loginCredentials);
}
