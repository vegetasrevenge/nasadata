package com.finalproject.nasadata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MeteoriteController {
    @Autowired
    private MeteoriteService meteoriteService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("api/meteorite")
    public String addCustomer(@RequestBody String json) throws IOException {
        Meteorite meteorite = objectMapper.readValue(json, Meteorite.class);
        meteoriteService.add(meteorite);
        return "add complete";
    }

    @GetMapping("api/meteorites")
    public List<Meteorite> getAll(Model model) {
        return meteoriteService.getAll();
    }

    @GetMapping("api/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }

}
