package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.domain.User;
import com.finalproject.nasadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String addUser(@Valid User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("registerMessage", "Congrats! You have been registered.");
        userService.add(user);
        return "redirect:/map";
    }
}
