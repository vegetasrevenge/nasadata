package com.finalproject.nasadata.service;

import com.finalproject.nasadata.domain.User;
import com.finalproject.nasadata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User add(User user) {return userRepository.save(user);}

//    @Transactional
//    @Override
//    public void (List<User> userList) {
//        for(User user: userList) {
//            userRepository.save(user);
//        }
//    }

//    @Override
//    public User getById(int id) {return userRepository.findOne(id);}

    @Override
    public User get(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

    @Override
    public List<User> getAll() {return userRepository.findAll();}

    @Transactional
    @Override
    public void update(User user) {userRepository.save(user);}

    @Transactional
    @Override
    public void delete(int id) {userRepository.delete(id);}
}
