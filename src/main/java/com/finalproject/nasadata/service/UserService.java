package com.finalproject.nasadata.service;

import com.finalproject.nasadata.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public User add(User user);
    void add(List<User> userList);
    User getById(int id);
    List<User> getAll();
    void update(User user);
    void delete(int id);
}
