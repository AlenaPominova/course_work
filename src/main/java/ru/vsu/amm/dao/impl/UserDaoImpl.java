package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.UserMapper;
import ru.vsu.amm.model.ParkingPlace;
import ru.vsu.amm.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.amm.queries.UserQueries;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements IDao<User> {

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public User insert(User user) {
        Object[] params = new Object[]{user.getUserId(), user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription()};
        return jdbcTemplateObject.queryForObject(UserQueries.CREATE_USER, params, new UserMapper());
    }

    public void delete(int id) {
        jdbcTemplateObject.update(UserQueries.DELETE_USER, id);
    }

    public User update(User user) {
        Object[] params = new Object[]{user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription(), user.getUserId()};

        return jdbcTemplateObject.queryForObject(UserQueries.UPDATE_USER, params, new UserMapper());
    }

    public User findById(int userId) {
        return jdbcTemplateObject.queryForObject(UserQueries.FIND_BY_ID,
                new Object[]{userId}, new UserMapper());
    }

    public User findByEmail(String email) {
        return jdbcTemplateObject.queryForObject(UserQueries.FIND_BY_ID,
                new Object[]{email}, new UserMapper());
    }

    public List<User> getAll() {
        return jdbcTemplateObject.query(UserQueries.GET_ALL, new UserMapper());
    }

    public String getRole(int id) {
        return jdbcTemplateObject.queryForObject(UserQueries.GET_ROLE, new Object[]{id}, String.class);
    }

    public List<ParkingPlace> getFavoritePlaces(int id){
        return jdbcTemplateObject.queryForList(UserQueries.GET_FAV_PLACES, new Object[]{id}, ParkingPlace.class);
    }
}

