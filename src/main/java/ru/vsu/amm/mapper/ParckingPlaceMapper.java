package ru.vsu.amm.mapper;

import ru.vsu.amm.model.ParckingPlace;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParckingPlaceMapper implements RowMapper<ParckingPlace> {

    @Nullable
    @Override
    public ParckingPlace mapRow(ResultSet resultSet, int i) throws SQLException {
        ParckingPlace parckingPlace = new ParckingPlace();
        parckingPlace.setId(resultSet.getInt("place_id"));
        parckingPlace.setLatitude(resultSet.getDouble("latitude"));
        parckingPlace.setLongitude(resultSet.getDouble("longitude"));
        parckingPlace.setPaid(resultSet.getBoolean("is_paid"));
        parckingPlace.setOpenTime(resultSet.getString("open_time"));
        parckingPlace.setCloseTime(resultSet.getString("close_time"));
        parckingPlace.setNumberOfFreeSpots(resultSet.getInt("num_of_free_spots"));
        parckingPlace.setNumberOfSpots(resultSet.getInt("num_of_spots"));
        parckingPlace.setAddress(resultSet.getString("address"));
        parckingPlace.setDescription(resultSet.getString("description"));
        return parckingPlace;
    }
}
