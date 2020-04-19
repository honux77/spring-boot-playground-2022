package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        RowMapper <User> userMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.addGithub(rs.getString("github_id"));
                user.setCreateDateFromString(rs.getString("created_date"));
                return user;
            }
        };

        return jdbcTemplate.queryForObject(sql, new Object[] {id}, userMapper);
    }
}
