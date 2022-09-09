package dev.daycareworkers.gradebook;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.dtos.Token;
import dev.daycareworkers.entities.UserAccount;
import dev.daycareworkers.exceptions.PasswordMismatchException;
import dev.daycareworkers.exceptions.UserNotFoundException;
import dev.daycareworkers.repos.UserAccountRepo;
import dev.daycareworkers.services.JwtService;
import dev.daycareworkers.services.LoginService;
import dev.daycareworkers.services.LoginServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTests {

    @Autowired
    JwtService jwtService;

    static UserAccountRepo userAccountRepo = Mockito.mock(UserAccountRepo.class);
    static LoginService loginService = new LoginServiceImpl(userAccountRepo);

    @Test
    void create_jwt() {
        Token jwt = jwtService.createJwtWithUsernameRoleAndFullname("Terry", "Wizard", "Terry Tim");
        System.out.println(jwt);
    }

    @Test
    public void authenticate_user_user_not_found_test() {
        LoginCredentials loginCredentials = new LoginCredentials("abc", "efg");
        Mockito.when(userAccountRepo.findByUsername(loginCredentials.getUsername())).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> loginService.authenticateUser(loginCredentials));
    }

    @Test
    public void authenticate_user_password_mismatch_test() {
        LoginCredentials loginCredentials = new LoginCredentials("abc", "efg");
        UserAccount userAccount = new UserAccount("", "abc", "EMP", "teacher", "Jim Joe");
        Mockito.when(userAccountRepo.findByUsername(loginCredentials.getUsername())).thenReturn(userAccount);
        Assertions.assertThrows(PasswordMismatchException.class, () -> loginService.authenticateUser(loginCredentials));
    }
}
