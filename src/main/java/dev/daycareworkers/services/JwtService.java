package dev.daycareworkers.services;

import dev.daycareworkers.entities.Token;

public interface JwtService {

    Token createJwtWithUsernameAndRole(String username, String Role);

    boolean validateJWT(String jwt);
}
