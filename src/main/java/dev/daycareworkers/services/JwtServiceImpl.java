package dev.daycareworkers.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import dev.daycareworkers.entities.Token;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    private final Algorithm algorithm = Algorithm.HMAC256("daycare workers");

    @Override
    public Token createJwtWithUsernameAndRole(String username, String role) {
        System.out.println("inside create JWT" + username + role);
        String jwt = JWT.create().withClaim("username", username).withClaim("role", role).sign(algorithm);
        System.out.println("printing " + jwt);
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
