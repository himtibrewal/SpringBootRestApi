package com.himanshu.springbootdemo.service;

import com.himanshu.springbootdemo.model.User;


public interface UserService {

    User getUser(Integer id);

    User createUser(User user);

    void deleteUser(Integer id);

    User updateUser(User user);
}
