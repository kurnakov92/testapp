package com.testapp.dao;

import com.testapp.entity.User;
import com.testapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        jdbcTemplate.update(sql, user.getName());
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());

    }
}
