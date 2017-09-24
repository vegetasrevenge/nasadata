package com.finalproject.nasadata.service;


import com.finalproject.nasadata.domain.Meteorite;

import java.util.List;

public interface MeteoriteService {
    public Meteorite add(Meteorite meteorite);
    void add(List<Meteorite> meteoriteList);
    Meteorite getById(int id);
    List<Meteorite> getAll();
    void update(Meteorite meteorite);
    void delete(int id);
}
