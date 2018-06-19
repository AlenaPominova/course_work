package ru.vsu.amm.mapper;

import ru.vsu.amm.model.ParkingPlace;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for mapping instances of {@link ParkingPlace}
 * @author Alena Pominova
 * @version 1.0
 */
public class ParkingPlaceMapper implements RowMapper<ParkingPlace> {

    /**
     * method for mapping ResultSet to fields of ParkingPlace class
     * @see ParkingPlace
     * @see ResultSet
     * @return ParkingPlace
     */
    @Nullable
    @Override
    public ParkingPlace mapRow(ResultSet resultSet, int i) throws SQLException {
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.setId(resultSet.getInt("place_id"));
        parkingPlace.setLatitude(resultSet.getDouble("latitude"));
        parkingPlace.setLongitude(resultSet.getDouble("longitude"));
        parkingPlace.setPrice(resultSet.getDouble("price"));
        parkingPlace.setPaid(resultSet.getBoolean("is_paid"));
        parkingPlace.setOpenTime(resultSet.getString("open_time"));
        parkingPlace.setCloseTime(resultSet.getString("close_time"));
        parkingPlace.setNumberOfFreeSpots(resultSet.getInt("num_of_free_spots"));
        parkingPlace.setAddress(resultSet.getString("address"));
        parkingPlace.setDescription(resultSet.getString("description"));
        return parkingPlace;
    }
}
