package ru.vsu.amm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.vsu.amm.model.ParkingPlace;
import ru.vsu.amm.services.impl.ParkingService;

@Controller
public class AdminController {
    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("object", parkingService.getAll());
        return model;
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.DELETE)
    public ModelAndView deleteParkingPlace(ParkingPlace parkingPlace) {
        parkingService.delete(parkingPlace);
        ModelAndView model = new ModelAndView("admin");
        model.addObject("object", parkingService.getAll());
        return model;
    }
}
