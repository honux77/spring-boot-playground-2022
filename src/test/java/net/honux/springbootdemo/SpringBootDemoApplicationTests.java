package net.honux.springbootdemo;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	ApplicationContext ctx;
	@Test
	void contextLoads() {
		assertThat(ctx).isNotNull();
	}

}
