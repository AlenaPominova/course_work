package ru.vsu.amm.mapper;

import ru.vsu.amm.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for mapping instances of {@link User}
 * @author Alena Pominova
 * @version 1.0
 */
public class UserMapper implements RowMapper<User> {

    /**
     * method for mapping ResultSet to fields of User class
     * @see User
     * @see ResultSet
     * @return User
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setFio(rs.getString("fio"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}