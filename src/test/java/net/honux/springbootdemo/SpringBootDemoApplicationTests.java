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
	void userRepo_FindByEmail() {
		String email = "honux@gmail.com"; //data.sql
		User user = userRepo.findUserByEmail(email).get();
		assertThat(user).isNotNull();
		logger.debug("Find user by Email {}: {}", email, user);
	}
}
