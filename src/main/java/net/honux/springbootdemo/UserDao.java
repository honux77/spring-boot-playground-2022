package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);
    /*spring.datasource.url=jdbc:mysql://localhost:3306/bootdb
spring.datasource.username=scott
spring.datasource.password=tiger57 */


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public Connection getConntection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("MySQL Driver error: {}", e.getMessage());
            return null;
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error("getConnection error: {}", e.getMessage());
            return null;
        }

        logger.debug("create connection success");
        return conn;
    }

    public User findbyId(Long id) {
        User user = new User();
        try (Connection conn = getConntection()) {
            Statement stmt = conn.createStatement();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
