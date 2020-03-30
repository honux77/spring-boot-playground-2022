package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private UserRepository userRepo;

	private Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

	@Test
	void contextLoads() {
		assertThat(ctx).isNotNull();
		logger.debug("ApplicationContext is not null");
	}

	@Test
	void LoggerNotNull() {
		assertThat(logger).isNotNull();
		logger.debug("Logger OK");
	}

	@Test
	void userRepo_FindById() {
		User user = userRepo.findById(1L).get();
		assertThat(user).isNotNull();
		logger.debug("Find user with Id 1: {}", user);
	}

	@Test
	void newUserNewGithub() {
		User user = new User("poogle@notd.com", null);
		userRepo.save(user);
		assertThat(user.getId()).isNotNull();
		logger.debug("new user info: {}", user);

		//set Github
		user.setGithub(new Github("IamGoogle"));
		userRepo.save(user);

		user = userRepo.findById(user.getId()).get();
		assertThat(user.getGithub()).isNotNull();
		logger.debug("after set Github and Save: {}", user);
	}

	@Test
	void userRepo_FindByEmail() {
		String email = "honux@gmail.com"; //data.sql
		User user = userRepo.findUserByEmail(email).get();
		assertThat(user).isNotNull();

		logger.debug("Find user by Email {}: {}", email, user);
		user.setGithub(new Github("bjack"));
		userRepo.save(user);
		user = userRepo.findUserByEmail(email).get();
		logger.debug("Find user by Email after add github {}: {}", email, user);
	}
}
