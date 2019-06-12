package ru.vsu.amm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.impl.ParkingPlaceDaoImpl;
import ru.vsu.amm.model.ParkingPlace;
import ru.vsu.amm.services.IService;

import java.util.List;

/**
 * Class for busness logic of {@link ParkingPlace}
 * @see IService
 * @author Alena Pominova
 * @version 1.0
 */
@Component("ParkingService")
public class ParkingService implements IService<ParkingPlace> {
    @Autowired
    private ParkingPlaceDaoImpl parkingDao;

//    @Autowired
//    public ParkingService(ParkingPlaceDaoImpl parkingDao){
//        this.parkingDao = parkingDao;
//    }

    @Override
    public void save(ParkingPlace obj) {
        parkingDao.insert(obj);
    }

    @Override
    public void delete(String id) {
        parkingDao.delete(Integer.valueOf(id));
    }

    @Override
    public ParkingPlace update(ParkingPlace obj) {
        return parkingDao.update(obj);
    }

    @Override
    public List<ParkingPlace> getAll() {
        return parkingDao.getAll();
    }

    public ParkingPlace findById(int id){
        return parkingDao.findById(id);
    }
}
