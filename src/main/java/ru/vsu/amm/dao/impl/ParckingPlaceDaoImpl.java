package ru.vsu.amm.dao.impl;

import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.ParckingPlaceMapper;
import ru.vsu.amm.model.ParckingPlace;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class ParckingPlaceDaoImpl implements IDao<ParckingPlace> {

    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(ParckingPlace obj) {
        String sql;
        sql = "INSERT INTO public.parcking_place(" +
                "place_id, latitude, longitude, is_paid, open_time, close_time, " +
                "            num_of_free_spots, num_of_spots, address, description) " +
                "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{
                obj.getId(), obj.getLatitude(), obj.getLongitude(), obj.getIsPaid(), obj.getOpenTime(), obj.getCloseTime(),
                obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription()
        };
        jdbcTemplateObject.update(sql, params);
    }

    @Override
    public void delete(int id) {
        String sql;
        sql = "DELETE FROM public.parcking_place" +
                " WHERE place_id = ?;";
        jdbcTemplateObject.update(sql, id);
    }

    @Override
    public void update(ParckingPlace obj) {
        String sql;
        sql = "UPDATE public.parcking_place " +
                "   SET latitude=?, longitude=?, is_paid=?, open_time=?, " +
                "       close_time=?, num_of_free_spots=?, num_of_spots=?, address=?, " +
                "       description=? " +
                " WHERE place_id = ?;";
        Object[] params = new Object[]{
                obj.getLatitude(), obj.getLongitude(), obj.getIsPaid(), obj.getOpenTime(), obj.getCloseTime(),
                obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription(), obj.getId()
        };
        jdbcTemplateObject.update(sql, params);
    }

    @Override
    public ParckingPlace findById(int id) {
        String sql;
        ResultSet rs = null;
        sql = "SELECT P.* FROM public.parcking_place P where P.place_id = ?";
        ParckingPlace parckingPlace = jdbcTemplateObject.queryForObject(sql,
                new Object[]{id}, new ParckingPlaceMapper());

        return parckingPlace;
    }

    @Override
    public List<ParckingPlace> getAll() {
        String SQL = "select P.* from public.parcking_place P";
        List <ParckingPlace> parckingPlaces = jdbcTemplateObject.query(SQL, new ParckingPlaceMapper());
        return parckingPlaces;
    }
}
