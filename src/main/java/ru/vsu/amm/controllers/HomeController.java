package ru.vsu.amm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.vsu.amm.services.impl.ParkingService;
import ru.vsu.amm.services.impl.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class controller
 * @see ParkingService
 * @see UserService
 * @author Alena Pominova
 * @version 1.0
 */
@Controller
public class HomeController {
    @Autowired
    private ParkingService parkingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/singup"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "singup";
    }

    @RequestMapping(value = {"/singin"}, method = RequestMethod.GET)
    public String showHomePage1() {
        return "singin";
    }

    @RequestMapping(value = {"/", "/map"}, method = RequestMethod.GET)
    public ModelAndView greeting() {
        ModelAndView model = new ModelAndView("map");
        model.addObject("object", parkingService.getAll());
        return model;
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)//TODO: нифига не работает
    public ModelAndView profile(/*@AuthenticationPrincipal User user*/) {
        ModelAndView model = new ModelAndView("map");
        model.addObject("user", userService.findByEmail(userService.findByEmail("petrov@gmail.com").toString()));
        return model;
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public void getSearchResultViaAjax(HttpServletResponse res) {
        String response = "";
        try{
            //запрос к базе, формируем то что хотим
//            response = parkingService.tring();
            res.getWriter().write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
