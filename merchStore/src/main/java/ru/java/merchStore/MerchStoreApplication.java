package ru.java.merchStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.java.merchStore.config.SecurityUtility;
import ru.java.merchStore.domain.User;
import ru.java.merchStore.domain.security.Role;
import ru.java.merchStore.domain.security.UserRole;
import ru.java.merchStore.service.UserService;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MerchStoreApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MerchStoreApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception{
		Set<UserRole> userRoles = new HashSet<>();

		//add users
		//user1=admin
		User user1 = new User();
		user1.setFirstName("Admin");
		user1.setLastName("Admin");
		user1.setUsername("Admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("Admin@gmail.com");
		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
		role1.setRoleId(0);
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);

		//user2=An Em
		User user2 = new User();
		user2.setFirstName("An");
		user2.setLastName("Em");
		user2.setUsername("AE");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("AE@gmail.com");
		Role role2 = new Role();
		role2.setName("ROLE_USER");
		role2.setRoleId(1);
		userRoles.add(new UserRole(user2, role2));
		userService.createUser(user2, userRoles);

	}
}
