package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.domain.User;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewsController {

    @Autowired
    MeteoriteService meteoriteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(RedirectAttributes redirectAttributes) {
        return "redirect:/map";}

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }




}
