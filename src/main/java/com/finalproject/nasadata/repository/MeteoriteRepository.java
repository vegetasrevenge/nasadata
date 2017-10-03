package com.finalproject.nasadata.repository;

import com.finalproject.nasadata.domain.Meteorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MeteoriteRepository extends JpaRepository<Meteorite, Integer> {




}
