package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.config.WebSecurityConfig;
import com.finalproject.nasadata.domain.User;
import com.finalproject.nasadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String addUser(User user, RedirectAttributes redirectAttributes) {
        userService.add(user);
        return "redirect:/map";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login"; }

    @RequestMapping(value="/login_post", method = RequestMethod.POST)
    public String login(User user) throws IOException {
        userService.get(user);
        return "redirect:/map";
    }
}
