package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.UserMapper;
import ru.vsu.amm.model.ParkingPlace;
import ru.vsu.amm.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.amm.queries.Factory.QueryFactory;
import ru.vsu.amm.queries.PostgreSQLQuery.PostgreSQLUserQueries;

import javax.sql.DataSource;
import java.util.List;

/**
 * Class for access to db {@link User}
 * @author Alena Pominova
 * @version 1.0
 */
@Component("UserDaoImpl")
public class UserDaoImpl implements IDao<User> {

    private JdbcTemplate jdbcTemplateObject;
    private QueryFactory queryFactory;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.queryFactory = QueryFactory.getFactory("PostgreSQL");
    }

    /**
     * method for inserting new user in db
     * @see PostgreSQLUserQueries#CREATE_USER
     * @param user
     * @return User
     */
    @Override
    public User insert(User user) {
        Object[] params = new Object[]{user.getUserId(), user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription(), user.getRole()};
        return jdbcTemplateObject.queryForObject(queryFactory.createUser(), params, new UserMapper());
    }

    /**
     * method for deleting user with id from db
     * @see PostgreSQLUserQueries#DELETE_USER
     * @param id
     * @return User
     */
    @Override
    public void delete(int id) {
        jdbcTemplateObject.update(queryFactory.deleteUsers(), id);
    }

    /**
     * method for updating user in db
     * @see PostgreSQLUserQueries#UPDATE_USER
     * @param user
     * @return User
     */
    @Override
    public User update(User user) {
        Object[] params = new Object[]{user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription(), user.getRole(), user.getUserId()};

        return jdbcTemplateObject.queryForObject(queryFactory.updateUsers(), params, new UserMapper());
    }

    /**
     * method for finding user by id in db
     * @see PostgreSQLUserQueries#FIND_BY_ID
     * @param userId
     * @return User
     */
    public User findById(int userId) {
        return jdbcTemplateObject.queryForObject(queryFactory.findByIdUser(),
                new Object[]{userId}, new UserMapper());
    }

    /**
     * method for finding user by email in db
     * @see PostgreSQLUserQueries#FIND_BY_EMAIL
     * @param email
     * @return User
     */
    public User findByEmail(String email) {
        return jdbcTemplateObject.queryForObject(queryFactory.findByEmailUser(),
                new Object[]{email}, new UserMapper());
    }

    /**
     * method for finding all users in db
     * @see PostgreSQLUserQueries#GET_ALL
     * @return List<User>
     */
    @Override
    public List<User> getAll() {
        return jdbcTemplateObject.query(queryFactory.getAllUsers(), new UserMapper());
    }

    public String getRole(int id) {
        return jdbcTemplateObject.queryForObject(queryFactory.getRole(), new Object[]{id}, String.class);
    }

    /**
     * method for finding favorite parking places for user with id in db
     * @see PostgreSQLUserQueries#GET_FAV_PLACES
     * @return List<ParkingPlace>
     */
    public List<ParkingPlace> getFavoritePlaces(int id){
        return jdbcTemplateObject.queryForList(queryFactory.getFavPlaces(), new Object[]{id}, ParkingPlace.class);
    }
}

