package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.ParkingPlaceMapper;
import ru.vsu.amm.model.ParkingPlace;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.amm.queries.ParkingQueries;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Component("ParkingPlaceDaoImpl")
public class ParkingPlaceDaoImpl implements IDao<ParkingPlace> {
    private JdbcTemplate jdbcTemplateObject;
    private ParkingQueries query;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public ParkingPlace insert(ParkingPlace obj) {
        Object[] params = new Object[]{
                obj.getId(), obj.getLatitude(), obj.getLongitude(), obj.getIsPaid(), obj.getOpenTime(), obj.getCloseTime(),
                obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription()
        };
        return jdbcTemplateObject.queryForObject(ParkingQueries.CREATE_PARKIING, params, new ParkingPlaceMapper());
    }

    public void delete(int id) {
        jdbcTemplateObject.update(ParkingQueries.UPDATE_PARKING, id);
    }

    public ParkingPlace update(ParkingPlace obj) {
        Object[] params = new Object[]{
                obj.getLatitude(), obj.getLongitude(), obj.getIsPaid(), obj.getOpenTime(), obj.getCloseTime(),
                obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription(), obj.getId()
        };
        return jdbcTemplateObject.queryForObject(ParkingQueries.UPDATE_PARKING, params, new ParkingPlaceMapper());
    }

    @Override
    public ParkingPlace findById(int id) {
        ParkingPlace parkingPlace = jdbcTemplateObject.queryForObject(ParkingQueries.FIND_BY_ID,
                new Object[]{id}, new ParkingPlaceMapper());

        return parkingPlace;
    }

    public ParkingPlace findByAddress(String address) {
        ParkingPlace parkingPlace = jdbcTemplateObject.queryForObject(ParkingQueries.FIND_BY_ADDRESS,
                new Object[]{address}, new ParkingPlaceMapper());

        return parkingPlace;
    }

    public List<ParkingPlace> getAll() {
        return jdbcTemplateObject.query(ParkingQueries.GET_ALL, new ParkingPlaceMapper());
    }
}
