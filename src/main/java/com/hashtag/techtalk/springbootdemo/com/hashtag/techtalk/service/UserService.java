package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.service;

import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model.User;

import java.util.List;

public interface UserService {
    public User getUserWithId(int id);
    public List<User> getAllUsers();
    public void saveUser(User user);
    public void deleteUser(User user);

    }
