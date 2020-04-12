package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import java.util.Optional;

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

    @Test
    void addGame() {
        User user = userRepo.findById(1L).get();
        user.addGame("ff7");
        user.addGame("dq5");
        userRepo.save(user);
        assertThat(userRepo.countGame(user.getId())).isEqualTo(2);
        logger.debug("User after add 2 games: {}", user);
        for (Game game: user.games()) {
            logger.debug("Game info: {}", game);
        }
    }

    @Test
    void check_created_date_is_not_null() {
        User user = new User("honux100@game.com");
        userRepo.save(user);
        assertThat(user.getCreatedDate()).isNotNull();
        logger.info("User create and save: {}", user);
    }

    @AfterEach
    void cleanup() {
        User user = userRepo.findById(1L).get();
        user.removeGithub();
        user.clearGame();
        userRepo.save(user);
        logger.debug("After remove github user {}: {}", github, user);
        Optional<User> optionalUser = userRepo.findUserByEmail("honux100@game.com");
        if (optionalUser.isPresent()) {
            userRepo.deleteById(optionalUser.get().getId());
        }
    }

}
