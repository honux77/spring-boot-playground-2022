package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private Connection getConntection() {
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

        String sql = "SELECT * FROM user where id=?";
        User user = new User();

        try (Connection conn = getConntection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) return null;

            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.addGithub(rs.getString("github_id"));
            user.setCreateDateFromString(rs.getString("created_date"));
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
