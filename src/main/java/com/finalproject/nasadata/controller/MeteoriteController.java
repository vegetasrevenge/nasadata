package com.finalproject.nasadata.controller;


import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import static com.sun.deploy.config.JREInfo.getAll;

@RestController
public class MeteoriteController {
    @Autowired
    private MeteoriteService meteoriteService;

    @PersistenceContext
    public EntityManager em;

    @GetMapping("api/meteorites")
    @SuppressWarnings("unchecked")
    public List<Meteorite> getMeteoritesByYear(@RequestParam(name = "min") Integer minimum, @RequestParam(name = "max") Integer maximum) {

        return em.createQuery("SELECT m FROM Meteorite m WHERE m.year > :minimum AND m.year < :maximum")
                .setParameter("minimum", minimum)
                .setParameter("maximum", maximum)
                .getResultList();
    }

    @GetMapping("api/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }
}
