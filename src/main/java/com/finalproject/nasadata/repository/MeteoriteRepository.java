package com.finalproject.nasadata.repository;

import com.finalproject.nasadata.domain.Meteorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteoriteRepository extends JpaRepository<Meteorite, Integer> {}
