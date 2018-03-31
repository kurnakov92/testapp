package com.testapp.service;

import com.testapp.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

}
