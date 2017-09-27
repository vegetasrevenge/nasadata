package com.finalproject.nasadata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static com.sun.deploy.config.JREInfo.getAll;

@RestController
public class MeteoriteController {
    @Autowired
    private MeteoriteService meteoriteService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("api/meteorites")
    public List<Meteorite> getMeteorites() {
        List<Meteorite> meteoriteList = meteoriteService.getAll();
        return meteoriteList.stream().limit(500).collect(Collectors.toList());
    }

    @GetMapping("api/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }


}
