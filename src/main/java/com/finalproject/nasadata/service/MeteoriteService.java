package com.finalproject.nasadata.service;


import com.finalproject.nasadata.domain.Meteorite;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MeteoriteService {
    public Meteorite add(Meteorite meteorite);
    void add(List<Meteorite> meteoriteList);
    Meteorite getById(int id);
    List<Meteorite> getAll();
    void update(Meteorite meteorite);
    void delete(int id);
    List<Meteorite> getAllBySomeCoolStuff(Integer minimum, Integer maximum, String fall, Double mass);
}
