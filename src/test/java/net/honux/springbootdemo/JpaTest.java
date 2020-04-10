package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JpaTest {

    private Logger logger = LoggerFactory.getLogger(JpaTest.class);
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        User user = new User("Honux");
        logger.info("user before save: {}", user);
        userRepository.save(user);
        assertThat(user.getCreatedDate()).isNotNull();
        logger.info("user save: {}", user);
    }

}
