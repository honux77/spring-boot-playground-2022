package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class DatabaseTest {

    @Autowired
    private UserRepository userRepo;
    private Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

    private final static String email = "honux@gmail.com"; //data.sql
    private final static String github = "octocat"; //data.sql


    @Test
    void userRepo_FindById() {
        User user = userRepo.findById(1L).get();
        assertThat(user).isNotNull();
        logger.debug("Find user with Id 1: {}", user);
    }

    @Test
    void userRepo_FindByEmail() {
        User user = userRepo.findUserByEmail(email).get();
        assertThat(user).isNotNull();
        logger.debug("Find user by Email {}: {}", email, user);
        user.addGithub(github);
        userRepo.save(user);
        user = userRepo.findUserByEmail(email).get();
        logger.debug("Find user by Email after add github{}: {}", email, user);
    }

    @Test
    void userRepo_addGithub() {
        User user = userRepo.findById(1L).get();
        user.addGithub(github);
        userRepo.save(user);
        assertThat(user.github().getId()).isEqualTo(github);
        logger.debug("After set and save github user {}: {}", github, user);
    }

    @AfterEach
    void removeGithub() {
        User user = userRepo.findById(1L).get();
        user.removeGithub();
        userRepo.save(user);
        logger.debug("After remove github user {}: {}", github, user);
    }

}
