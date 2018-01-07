package ru.vsu.amm.dao.impl;

import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.UserMapper;
import ru.vsu.amm.model.ParckingPlace;
import ru.vsu.amm.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoTmpImpl implements IDao<User> {

    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(User user) {
        String sql;
        sql = "INSERT INTO public.user(" +
                "            user_id, email, password, fio, description)\n" +
                "    VALUES (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, user.getUserId(), user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription());
    }

    public void delete(int id) {
        String sql;
        sql = "DELETE FROM public.user" +
                " WHERE user_id = ?";
        jdbcTemplateObject.update(sql, id);
    }

    public void update(User user) {
        String sql;
        sql = "UPDATE public.user" +
                "   SET email=?, password=?, fio=?, description=?\n" +
                " WHERE user_id = ?;";

        jdbcTemplateObject.update(sql, user.getEmail(), user.getPassword(),
                user.getFio(), user.getDescription(), user.getUserId());
    }

    public User findById(int userId) {
        String sql;
        ResultSet rs = null;
        sql = "SELECT U.* FROM public.USER U where U.user_id = ?";
        User user = jdbcTemplateObject.queryForObject(sql,
                new Object[]{userId}, new UserMapper());

        return user;
    }

    public List<User> getAll() {
        String sql = "select * from public.USER";
        List <User> users = jdbcTemplateObject.query(sql, new UserMapper());
        return users;
    }

    public String getRole(int id) {
        String sql = "select R.name " +
                " from user_role U " +
                "      left join roles R " +
                "       on U.role_id = R.role_id " +
                " where U.user_id = ?;";
        String role = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, String.class);
        return role;
    }

    public List<ParckingPlace> getFavoritePlaces(int id){
        String sql = "select P.* " +
                "  from favorite_places F " +
                "       left join parcking_place P " +
                "        on F.parking_place_id = P.place_id " +
                "  where F.user_id = ?;";
        List<ParckingPlace> favPlaces = jdbcTemplateObject.queryForList(sql, new Object[]{id}, ParckingPlace.class);
        return favPlaces;
    }
}

