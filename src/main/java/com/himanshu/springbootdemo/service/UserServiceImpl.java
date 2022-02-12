package com.himanshu.springbootdemo.service;

import com.himanshu.springbootdemo.model.User;
import com.himanshu.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDeletedAt(null);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User Not Available");
        }
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User olduser = userRepository.findById(user.getId()).orElse(null);
        if (olduser == null) {
            throw new RuntimeException("User Not Available");
        }
        olduser.setUpdatedAt(LocalDateTime.now());
        olduser.setAddress(user.getAddress());
        olduser.setName(user.getName());
        return userRepository.save(olduser);
    }
}
