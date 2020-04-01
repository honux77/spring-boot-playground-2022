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

	private void addUserGame(User user) {
		user.addGame("FF7");
		user.addGame("DQ5");
	}

	@Test
	void addGame() {
		User user = userRepo.findById(1L).get();
		addUserGame(user);
		userRepo.save(user);
		assertThat(userRepo.countGameforUser(user.getId())).isEqualTo(2);
		logger.debug("Add game - user info: {}", user);
		user.getGames().entrySet().stream().forEach(game -> {
			logger.debug("After save user and game: {}", game);
		});
	}


	User getUserByEmail() {
		String email = "honux@gmail.com"; //data.sql
		return userRepo.findUserByEmail(email).get();
	}

	@Test
	void userRepo_FindByEmail() {
		User user = getUserByEmail();
		assertThat(user).isNotNull();
		logger.debug("Find user by Email: {}", user);
	}

	@Test
	void userRepo_findByEmailandAddGame() {
		String email = "honux@gmail.com"; //data.sql
		User user = userRepo.findUserByEmail(email).get();
		logger.debug("Find user by Email {}: {}", email, user);
		addUserGame(user);
		userRepo.save(user);
		logger.debug("Find user by Email after save and add Game {}: {}", email, user);

		user.getGames().entrySet().stream().forEach(game -> {
			logger.debug("After save user and game: {}", game);
		});
	}

	@AfterEach
	void clearGames() {
		User user = getUserByEmail();
		user.clearGame();
		userRepo.save(user);
	}
}
