package com.testapp.dao;

import com.testapp.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    List<User> findAll();
}
