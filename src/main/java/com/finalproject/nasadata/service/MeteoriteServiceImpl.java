package com.finalproject.nasadata.service;

import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.repository.MeteoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MeteoriteServiceImpl implements MeteoriteService {

    @Autowired
    MeteoriteRepository meteoriteRepository;

    @PersistenceContext
    public EntityManager em;

    @Transactional
    @Override
    public Meteorite add(Meteorite meteorite) {
        return meteoriteRepository.save(meteorite);
    }
    @Transactional
    @Override
    public void add(List<Meteorite> meteoriteList) {
        for(Meteorite meteorite: meteoriteList) {
            meteoriteRepository.save(meteorite);
        }
    }
    @Override
    public Meteorite getById(int id) {
        return meteoriteRepository.findOne(id);
    }
    @Override
    public List<Meteorite> getAll() { return meteoriteRepository.findAll(); }
    @Transactional
    @Override
    public void update(Meteorite meteorite) {
        meteoriteRepository.save(meteorite);
    }

    @Transactional
    @Override
    public void delete(int id) {
        meteoriteRepository.delete(id);
    }

    @SuppressWarnings("unchecked")
    public List<Meteorite> getAllBySomeCoolStuff(Integer minimum, Integer maximum, String fall){
        if(fall == null || fall.isEmpty()){
            fall = "%";
        }

        List<Meteorite> meteoriteList = em.createQuery("SELECT m FROM Meteorite m WHERE m.year > :minimum AND m.year < :maximum AND m.fall like :fall")
                .setParameter("minimum", minimum)
                .setParameter("maximum", maximum)
                .setParameter("fall", fall)
                .getResultList();


        return meteoriteList;
    }
}
