package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.service;

import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model.User;
import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.repository.RedisUserRepository;
import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisUserRepository redisUserRepository;

    private boolean fetchFromRedis = true;

    @Override
    public User getUserWithId(int id) {
        if(fetchFromRedis){
           return redisUserRepository.findById(id);
        }
        System.out.println("Fetching from DB");
        return userRepository.getOne(id);
    }

    public void saveUser(User user){
        try{  redisUserRepository.save(user);}
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void deleteUser(User user){
        try{  redisUserRepository.delete(user.getUserId());}
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<User> getAllUsers() {
        Instant start = Instant.now();
        List<User> userList =   redisUserRepository.findAll();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken from redis inside Service all users: "+ timeElapsed.toMillis() +" milliseconds");
        start = Instant.now();
        userRepository.findAll();
        end = Instant.now();
         timeElapsed = Duration.between(start, end);
        System.out.println("Time taken from DB Service all users "+ timeElapsed.toMillis() +" milliseconds");
        return userList;
    }
}
