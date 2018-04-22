//package ru.vsu.amm.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.vsu.amm.model.User;
//import ru.vsu.amm.services.impl.UserService;
//import ru.vsu.amm.validator.Validator;
//
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private Validator validator;
//
//    @RequestMapping(value = {"/singup"}, method = RequestMethod.GET)
//    public String singup(Model model){
//        model.addAttribute("userForm", new User());
//        return "singup";
//    }
//
//    @RequestMapping(value = {"/singup"}, method = RequestMethod.POST)
//    public String singup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
//        validator.validate(userForm, bindingResult);
//
//        if(bindingResult.hasErrors()){
//            return "singup";
//        }
//
//        userService.save(userForm);
//        return "redirect:/map";
//    }
//
//    @RequestMapping(value = "/singin", method = RequestMethod.GET)
//    public String singin(Model model, String error, String logout){
//        if (error != null){
//            model.addAttribute("error", "Username or Password is incorrect");
//        }
//
//        if (logout != null){
//            model.addAttribute("message", "Logget out successfully");
//        }
//
//        return "singin";
//    }
//
//    @RequestMapping(value = {"/", "/map"}, method = RequestMethod.GET)
//    public String map(Model model){
//        return "map";
//    }
//
//    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
//    public String profile(Model model){
//        return "profile";
//    }
//}
