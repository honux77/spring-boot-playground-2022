package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SpringDataJdbcTest {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private UserRepository userRepo;

    private Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

    @Test
    void userRepo_FindById() {
        User user = userRepo.findById(1L).get();
        assertThat(user).isNotNull();
        logger.debug("Find user with Id 1: {}", user);
        user.setGithub(new Github(user.getEmail(), "MyGitHubId"));
        userRepo.save(user);
        logger.debug("User after set GitHub account: {}", user);
    }

    @Test
    void userRepo_FindByEmail() {
        String email = "honux@gmail.com"; //data.sql
        Optional<User> optionalUser = userRepo.findUserByEmail(email);
        assertThat(optionalUser.isPresent()).isTrue();
        User user = optionalUser.get();
        logger.debug("Find user by Email {}: {}", email, user);
        user.setGithub(new Github(user.getEmail(), "MyGitHubId"));
        userRepo.save(user);
        logger.debug("User after set GitHub account: {}", user);
    }

    @Test
    void userRepo_save() {
        String email = "alice@g.com";
        User user = new User(email, new Github("alice@g.com", "alice"));
        userRepo.save(user);
        assertThat(user.getId()).isNotNull();
        logger.debug("User after save: {}", user);
    }

    @Test
    void userRepo_setGitHub() {
        User user = userRepo.findById(1L).get();
        assertThat(user).isNotNull();
        logger.debug("Find user with Id 1: {}", user);

    }

    @Test
    void userRepo_addGame() {
        User user = userRepo.findById(1L).get();
        user.addGame(new Game("FF6"));
        user.addGame(new Game("DQ5"));
        userRepo.save(user);
        logger.debug("After add games: {}", user);
        for(Game g: user.getGames()) {
            logger.debug("Game: {}", g);
        }

        assertThat(userRepo.gameCount(user.getId())).isEqualTo(2);
        logger.debug("Game count: {}", userRepo.gameCount(user.getId()));

        user.removeAllGame();
        userRepo.save(user);
        assertThat(userRepo.gameCount(user.getId())).isEqualTo(0);
        logger.debug("Game count after erase: {}", userRepo.gameCount(user.getId()));
    }

}