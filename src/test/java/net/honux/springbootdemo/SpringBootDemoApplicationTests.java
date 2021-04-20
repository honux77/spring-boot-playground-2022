package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@Transactional
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
		Github gh = user.getGithub();
		assertThat(gh).isNotNull();


		Long id3 = 3L;
		user = userRepository.findById(id3).get();
		assertThat(user).isNotNull();
		gh = user.getGithub();
		assertThat(gh).isNull();
		logger.info("User ID {}: {}", id3, user);

		Long id2 = 9999L;
		assertThat(userRepository.findById(id2).isPresent()).isFalse();

		Iterable<User> users = userRepository.findAll();
		assertThat(((Collection) users).size()).isEqualTo(3);

		assertThat(userRepository.count()).isEqualTo(3);
	}

	@Test
	@DisplayName("DerivedQuery를 사용 이름과 이메일로 유저 정보를 가져올 수 있어야 한다.")
	void readUserNameAndEmail() {
		String name = "honux";
		String email = "crong@b.io";
		String wname = "jk";

		User user = userRepository.findUserByName(name).get();
		assertThat(user.getName()).isEqualTo(name);

		user = userRepository.findUserByEmail(email).get();
		assertThat(user.getEmail()).isEqualTo(email);

		assertThat(userRepository.findUserByName(wname).isPresent()).isFalse();
	}

	@Test
	@DisplayName("새로운 유저 생성이 되는지 확인")
	void create() {
		User user = new User("test@zz.com", "hello");
		user.setGithub(new Github("zzz", "https://qqqqqq/why_laugh"));
		user = userRepository.save(user);
		assertThat(user.getId()).isGreaterThanOrEqualTo(2);
		logger.info("Create new user {}", user);
	}

	@Test
	@DisplayName("유저 정보 업데이트")
	void update() {
		String name = "Jane";
		User user = new User("j@jj.com", "John");
		user.setGithub(new Github("qqqqq", "http://qqqqqq"));
		user = userRepository.save(user);
		user.setName(name);
		user = userRepository.save(user);
		User user2 = userRepository.findUserByName(name).get();
		assertThat(user.getId()).isEqualTo(user2.getId());
		assertThat(user2.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("유저 정보 삭제")
	void delete() {
		Long id1 = 1L;
		Long id2 = 2L;
		User user = userRepository.findById(id1).get();
		userRepository.delete(user);
		userRepository.deleteById(id2);
		assertThat(userRepository.count()).isEqualTo(0);
	}
}
