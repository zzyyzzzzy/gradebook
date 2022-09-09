package dev.daycareworkers.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import dev.daycareworkers.dtos.Token;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    private final Algorithm algorithm = Algorithm.HMAC256("daycare workers");

    @Override
    public Token createJwtWithUsernameRoleAndFullname(String username, String role, String fullname) {
        String jwt = JWT.create().withClaim("username", username)
                .withClaim("role", role).withClaim("fullname", fullname).sign(algorithm);
        return new Token(jwt);
    }

    @Override
    public boolean validateJWT(String jwt) {
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            verifier.verify(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
