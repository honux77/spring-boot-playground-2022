package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserDaoTest {

    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    void userDao_findById() {
        User user = userDao.findById(1L);
        assertThat(user).isNotNull();
        logger.info("Find user by userDao: {}", user);
    }

    @Test
    void userDao_insert() {
        User user = new User("honux2@google.com");
        user.addGithub("honux2");
        user = userDao.insert(user);
        int n = userDao.countAllUsers();
        assertThat(n > 1).isTrue();
        assertThat(user.getId()).isNotNull();

        logger.info("User count: {}", n);
        logger.info("Usr after save: {}", user);
    }

    @Test
    void userData_count_is_not_zero() {
        int n = userDao.countAllUsers();
        assertThat(n).isNotEqualTo(0);
        logger.info("User count: {}", n);
    }

    @AfterEach
    void cleanup() {
        userDao.deleteOther(1L);
    }
}
