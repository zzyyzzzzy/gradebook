package dev.daycareworkers.services;

import dev.daycareworkers.dtos.Token;

public interface JwtService {

    Token createJwtWithUsernameRoleAndFullname(String username, String role, String fullname);

    boolean validateJWT(String jwt);
}
