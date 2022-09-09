package dev.daycareworkers.services;

import dev.daycareworkers.dtos.LoginCredentials;
import dev.daycareworkers.dtos.Token;
import dev.daycareworkers.entities.UserAccount;
import dev.daycareworkers.exceptions.PasswordMismatchException;
import dev.daycareworkers.exceptions.UserNotFoundException;
import dev.daycareworkers.repos.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserAccountRepo userAccountRepo;

    public LoginServiceImpl() {
    }

    public LoginServiceImpl(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @Override
    public Token authenticateUser(LoginCredentials loginCredentials) {

        UserAccount userAccount = userAccountRepo.findByUsername(loginCredentials.getUsername());
        if (userAccount == null){
            throw new UserNotFoundException();
        }
        if (!userAccount.getPassword().equals(loginCredentials.getPassword())){
            throw new PasswordMismatchException();
        }
        return jwtService.createJwtWithUsernameRoleAndFullname(userAccount.getUsername(),
                userAccount.getRole(), userAccount.getFullname());
    }
}
