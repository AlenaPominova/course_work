package ru.vsu.amm.queries.Factory;

import org.springframework.stereotype.Component;
import ru.vsu.amm.queries.PostgreSQLQuery.PostgreSQLParkingQueries;
import ru.vsu.amm.queries.PostgreSQLQuery.PostgreSQLUserQueries;

@Component("PostgreSQLQueryFactory")
public class PostgreSQLQueryFactory extends QueryFactory {
    @Override
    public String createUser() {
        return PostgreSQLUserQueries.CREATE_USER;
    }

    @Override
    public String findByIdUser() {
        return PostgreSQLUserQueries.FIND_BY_ID;
    }

    @Override
    public String findByEmailUser() {
        return PostgreSQLUserQueries.FIND_BY_EMAIL;
    }

    @Override
    public String getAllUsers() {
        return PostgreSQLUserQueries.GET_ALL;
    }

    @Override
    public String deleteUsers() {
        return PostgreSQLUserQueries.DELETE_USER;
    }

    @Override
    public String updateUsers() {
        return PostgreSQLUserQueries.UPDATE_USER;
    }

    @Override
    public String createParking() {
        return PostgreSQLParkingQueries.CREATE_PARKIING;
    }

    @Override
    public String findByIdParking() {
        return PostgreSQLParkingQueries.FIND_BY_ID;
    }

    @Override
    public String findByAddressParking() {
        return PostgreSQLParkingQueries.FIND_BY_ADDRESS;
    }

    @Override
    public String getAllParking() {
        return PostgreSQLParkingQueries.GET_ALL;
    }

    @Override
    public String deleteParking() {
        return PostgreSQLParkingQueries.DELETE_PARKING;
    }

    @Override
    public String updateParking() {
        return PostgreSQLParkingQueries.UPDATE_PARKING;
    }

    @Override
    public String getRole() {
        return PostgreSQLUserQueries.GET_ROLE;
    }

    @Override
    public String getFavPlaces() {
        return PostgreSQLUserQueries.GET_FAV_PLACES;
    }
}
