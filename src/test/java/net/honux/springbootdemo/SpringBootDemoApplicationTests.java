package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SpringBootDemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);
	@Autowired
	private ApplicationContext ctx;
	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("IoC컨테이너 정상 동작 확인")
	void contextLoads() {
		assertThat(logger).isNotNull();
		assertThat(ctx).isNotNull();
	}

	@Test
	@DisplayName("Spring Data JDBC MySQL 연동 확인")
	void readUser() {
		Long id = 1L;
		User user = userRepository.findById(id).get();
		assertThat(user).isNotNull();
		logger.info("User ID {}: {}", id, user);

		Long id2 = 3L;
		assertThat(userRepository.findById(id2).isPresent()).isFalse();

		Iterable<User> users = userRepository.findAll();
		assertThat(((Collection) users).size()).isEqualTo(2);
	}
}
