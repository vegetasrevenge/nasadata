package com.finalproject.nasadata.restController;


import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MeteoriteRestController {

    @Autowired
    private MeteoriteService meteoriteService;

    @PersistenceContext
    public EntityManager em;

    @GetMapping("api/meteorites")
    @SuppressWarnings("unchecked")
    public List<Meteorite> getMeteorites(@RequestParam(name = "min") Integer minimum, @RequestParam(name = "max") Integer maximum, @RequestParam(name = "fall") String fall) {

        return em.createQuery("SELECT m FROM Meteorite m WHERE m.year > :minimum AND m.year < :maximum AND m.fall LIKE :fall ")
                .setParameter("minimum", minimum)
                .setParameter("maximum", maximum)
                .setParameter("fall", fall)
                .getResultList();
    }



    @GetMapping("api/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }

}

