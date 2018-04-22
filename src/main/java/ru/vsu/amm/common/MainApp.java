package ru.vsu.amm.common;

import ru.vsu.amm.model.ParkingPlace;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vsu.amm.services.impl.ParkingService;

import java.util.List;

public class MainApp {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ParkingService parkingService = (ParkingService) context.getBean("parkingService");

        System.out.println("------Listing Multiple Records--------" );
        ParkingPlace parkingPlaces = parkingService.findById(1);
        List<ParkingPlace> list = parkingService.getAll();

            System.out.print("Lat : " + parkingPlaces.getLatitude() );
            System.out.print(", long : " + parkingPlaces.getLongitude() );
            System.out.println(", free spots : " + parkingPlaces.getNumberOfFreeSpots());

    }
}
