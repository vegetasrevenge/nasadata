package com.finalproject.nasadata.restController;


import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
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
    public List<Meteorite> getMeteorites(@RequestParam(name = "min") Integer minimum,
                                         @RequestParam(name = "max") Integer maximum,
                                         @RequestParam(name = "fall", required = false) String fall,
                                         @RequestParam(name = "mass", required = false) Double mass
    ) {
            return meteoriteService.getAllBySomeCoolStuff(minimum, maximum, fall, mass);
    }

    @GetMapping("api/search_by_details")
    @SuppressWarnings("unchecked")
    public List<Meteorite> getMeteoritesByDetail(@RequestParam(name = "fall") String fall){
        List<Meteorite> detailList = meteoriteService.getAll()
                .stream()
                .filter(meteorite -> meteoriteService.equals(fall))
                .collect(Collectors.toList());
        System.out.println(detailList);
        return detailList;
    }


    @GetMapping("api/meteorites/{id}")
    public Meteorite getMeteorite(@PathVariable("id") Integer id) {
        return meteoriteService.getById(id);
    }

}

