package com.finalproject.nasadata.repository;

import com.finalproject.nasadata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
