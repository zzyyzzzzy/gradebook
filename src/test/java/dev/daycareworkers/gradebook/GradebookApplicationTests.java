package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.UserAccount;
import dev.daycareworkers.repos.UserAccountRepo;
import dev.daycareworkers.services.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GradebookApplicationTests {

	@Autowired
	UserAccountRepo userAccountRepo;

//	@Autowired
//	JwtService jwtService;

	@Test
	void contextLoads() {
	}
}
