package com.pranoy.phonebook.rm;

import com.pranoy.phonebook.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Pranoy
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();

        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("gmail"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        u.setRole(rs.getInt("role"));
        u.setLoginStatus(rs.getInt("loginStatus"));

        return u;
    }

}
