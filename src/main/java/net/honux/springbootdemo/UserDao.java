package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public int countAllUsers() {
        String sql = "SELECT count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    //it's insert not save! why?
    public User insert(User user) {
        String sql = "insert into user(email, github_id, created_date) values(?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.github().getId(), user.getFormattedCreatedDate());

        sql = "select id from user where email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", user.getEmail());
        long id = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Long.class);
        user.setId(id);
        return user;
    }

    public void deleteOther(Long id){
        String sql = "delete from user where id <> ?";
        jdbcTemplate.update(sql, id);
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
