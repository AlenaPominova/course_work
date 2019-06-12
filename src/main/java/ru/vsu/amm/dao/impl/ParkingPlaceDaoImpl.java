package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.mapper.ParkingPlaceMapper;
import ru.vsu.amm.model.ParkingPlace;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.amm.queries.Factory.QueryFactory;
import ru.vsu.amm.queries.PostgreSQLQuery.PostgreSQLParkingQueries;

import javax.sql.DataSource;
import java.util.List;

/**
 * Class for access to db {@link ParkingPlace}
 * @author Alena Pominova
 * @version 1.0
 */
@Component("ParkingPlaceDaoImpl")
public class ParkingPlaceDaoImpl implements IDao<ParkingPlace> {
    private final String FACTORY_TYPE = "PostgreSQLQueryFactory";

    private JdbcTemplate jdbcTemplateObject;
    private QueryFactory queryFactory;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.queryFactory = QueryFactory.getFactory("PostgreSQL");
    }

    /**
     * method for inserting parking place in db
     * @see PostgreSQLParkingQueries#CREATE_PARKIING
     * @return ParkingPlace
     */
    @Override
    public ParkingPlace insert(ParkingPlace obj) {
        Object[] params = new Object[]{
                obj.getId(), obj.getLatitude(), obj.getLongitude(), obj.getPrice(), obj.getIsPaid(), obj.getOpenTime(),
                obj.getCloseTime(), obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription()
        };
        return jdbcTemplateObject.queryForObject(queryFactory.createParking(), params, new ParkingPlaceMapper());
    }

    /**
     * method for deleting parking place from db
     * @see PostgreSQLParkingQueries#DELETE_PARKING
     * @param id
     */
    @Override
    public void delete(int id) {
        jdbcTemplateObject.update(queryFactory.deleteFavPlaces(), id);
        jdbcTemplateObject.update(queryFactory.deleteParking(), id);
    }

    /**
     * method for updating parking place in db
     * @see PostgreSQLParkingQueries#UPDATE_PARKING
     * @param obj
     * @return ParkingPlace
     */
    @Override
    public ParkingPlace update(ParkingPlace obj) {
        Object[] params = new Object[]{
                obj.getLatitude(), obj.getLongitude(), obj.getPrice(), obj.getIsPaid(), obj.getOpenTime(), obj.getCloseTime(),
                obj.getNumberOfFreeSpots(), obj.getNumberOfSpots(), obj.getAddress(), obj.getDescription(), obj.getId()
        };
        return jdbcTemplateObject.queryForObject(queryFactory.updateParking(), params, new ParkingPlaceMapper());
    }

    /**
     * method for finding parking place by id in db
     * @see PostgreSQLParkingQueries#FIND_BY_ID
     * @param id
     * @return ParkingPlace
     */
    @Override
    public ParkingPlace findById(int id) {
        ParkingPlace parkingPlace = jdbcTemplateObject.queryForObject(queryFactory.findByIdParking(),
                new Object[]{id}, new ParkingPlaceMapper());

        return parkingPlace;
    }

    /**
     * method for finding parking place by address in db
     * @see PostgreSQLParkingQueries#FIND_BY_ADDRESS
     * @param address
     * @return ParkingPlace
     */
    public ParkingPlace findByAddress(String address) {
        ParkingPlace parkingPlace = jdbcTemplateObject.queryForObject(queryFactory.findByAddressParking(),
                new Object[]{address}, new ParkingPlaceMapper());

        return parkingPlace;
    }

    /**
     * method for finding all parking places in db
     * @see PostgreSQLParkingQueries#GET_ALL
     * @return List<ParkingPlace>
     */
    public List<ParkingPlace> getAll() {
        return jdbcTemplateObject.query(queryFactory.getAllParking(), new ParkingPlaceMapper());
    }
}
