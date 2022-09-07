package dev.daycareworkers.services;

public interface JwtService {

    String createJwtWithUsernameAndRole(String username, String Role);

    boolean validateJWT(String jwt);
}
