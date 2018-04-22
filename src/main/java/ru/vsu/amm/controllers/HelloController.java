//package ru.vsu.amm.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import ru.vsu.amm.services.impl.ParkingService;
//
//@Controller
//public class HelloController {
//    private ParkingService parkingService;
//
//    @Autowired
//    public HelloController(ParkingService parkingService){
//        this.parkingService = parkingService;
//    }
//
//    @RequestMapping(value = { "/", "/map**"}, method = RequestMethod.GET)
//    public ModelAndView welcomePage() {
//        ModelAndView model = new ModelAndView();
////        model.addObject("title", "Spring Security Hello World");
////        model.addObject("message", "This is welcome page!");
//        model.setViewName("map");
//        model.addObject("object", parkingService.getAll());
//        return model;
//    }
//
//    @RequestMapping(value = "/singin", method = RequestMethod.GET)
//    public ModelAndView singin(
//            @RequestParam(value = "error", required = false) String error,
//            @RequestParam(value = "logout", required = false) String logout){
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("singin");
//        return model;
//    }
//
//    @RequestMapping(value = "/profile**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//        ModelAndView model = new ModelAndView();
////        model.addObject("title", "Spring Security Hello World");
////        model.addObject("message", "This is protected page - Admin Page!");
//        model.setViewName("profile");
//        return model;
//    }
//
//    @RequestMapping(value = "/singup**", method = RequestMethod.GET)
//    public ModelAndView dbaPage() {
//        ModelAndView model = new ModelAndView();
////        model.addObject("title", "Spring Security Hello World");
////        model.addObject("message", "This is protected page - Database Page!");
//        model.setViewName("singup");
//        return model;
//    }
//
//}