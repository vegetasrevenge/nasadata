package com.finalproject.nasadata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import static com.sun.deploy.config.JREInfo.getAll;

@RestController
public class MeteoriteController {
    @Autowired
    private MeteoriteService meteoriteService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/meteorites")
    public String getMeteorites(Model model) {
        model.addAttribute("meteorites", getAll()).toString();
        System.out.println(model);
        return "meteorites";
    }

    @GetMapping("/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }


}
