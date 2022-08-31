package dev.daycareworkers.gradebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.daycareworkers")
@EntityScan(basePackages = "dev.daycareworkers.entities")
@EnableJpaRepositories("dev.daycareworkers.repos")
public class GradebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradebookApplication.class, args);
	}

}
