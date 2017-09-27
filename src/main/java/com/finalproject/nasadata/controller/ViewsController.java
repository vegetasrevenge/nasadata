package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewsController {

    @Autowired
    MeteoriteService meteoriteService;

    @RequestMapping(value = "/meteorites", method = RequestMethod.GET)
    public String allMeteorites(Model model) {
        model.addAttribute("meteorites", getAll());
        return "meteorites";
    }

    public List<Meteorite> getAll(){
        List<Meteorite> meteorites = meteoriteService.getAll().stream().limit(10).collect(Collectors.toList());
        return meteorites;
    }


}
