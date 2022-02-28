package com.ngimbis.labs.watchthis;

import com.ngimbis.labs.watchthis.domain.Role;
import com.ngimbis.labs.watchthis.domain.User;
import com.ngimbis.labs.watchthis.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WatchthisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchthisApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Philippe KKAI", "philippe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "DOUGA", "douga", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "PLAKIM", "plakim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kwang KAI", "kwang", "1234", new ArrayList<>()));

			userService.addRoleToUser("philippe", "ROLE_USER");
			userService.addRoleToUser("philippe", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("douga", "ROLE_MANAGER");
			userService.addRoleToUser("kwang", "ROLE_ADMIN");
			userService.addRoleToUser("plakim", "ROLE_MANAGER");
		};
	}

}
