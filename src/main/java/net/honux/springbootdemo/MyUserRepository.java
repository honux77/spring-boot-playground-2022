package net.honux.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class MyUserRepository {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    public User findById(Long id) {
        Connection conn = getConnection();
        String sql = "SELECT id, email from user where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
            }
            conn.close();
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
