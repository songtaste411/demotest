package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectList() {
        return userMapper.getAll();
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public void delete(Integer id) {
        userMapper.delete(id);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public User getById(int id) {
        return userMapper.get(id);

    }

    public User loging(User user) {
        return userMapper.loging(user);
    }
}
