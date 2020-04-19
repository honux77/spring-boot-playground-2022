package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int countAllUsers() {
        String sql = "SELECT count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] {id}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.addGithub(rs.getString("github_id"));
            user.setCreateDateFromString(rs.getString("created_date"));
            return user;
        });
    }
}
