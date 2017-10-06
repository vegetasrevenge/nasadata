package com.finalproject.nasadata.service;

import com.finalproject.nasadata.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User get(User user);
    User add(User user);
    List<User> getAll();
    void update(User user);
    void delete(int id);
}
