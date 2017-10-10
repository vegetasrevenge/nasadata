package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.domain.User;
import com.finalproject.nasadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        return "redirect:/map";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login"; }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logout(User user) {
        userService.get(user);
        return "redirect:/map";
    }

}
