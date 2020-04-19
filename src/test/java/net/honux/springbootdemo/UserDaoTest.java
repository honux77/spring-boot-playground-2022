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
}
