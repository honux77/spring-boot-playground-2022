package net.honux.springbootdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class JDBCTest {

    @Autowired
    MyUserRepository repo;

    @Test
    @DisplayName("커넥션이 살아있는지 확인")
    void connectionTest() {
        assertThat(repo.getConnection()).isNotNull();
    }

    @Test
    @DisplayName("유저 한 명 가져오기")
    void getUser() {
        assertThat(repo.findById(1L).getId()).isEqualTo(1);
    }
}
