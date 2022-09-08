package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.Token;
import dev.daycareworkers.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTests {

    @Autowired
    JwtService jwtService;

    @Test
    void create_jwt() {
        Token jwt = jwtService.createJwtWithUsernameAndRole("Terry", "Wizard");
        System.out.println(jwt);
    }
}
