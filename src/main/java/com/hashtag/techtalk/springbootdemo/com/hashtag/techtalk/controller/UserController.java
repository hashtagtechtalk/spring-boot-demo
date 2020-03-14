package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.controller;

import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model.User;
import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/save")
    public User saveUser(@RequestBody User user){
        Instant start = Instant.now();
        userService.saveUser(user);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken from DB controller: "+ timeElapsed.toMillis() +" milliseconds");
         start = Instant.now();
        User u= userService.getUserWithId(user.getUserId());
        end = Instant.now();
         timeElapsed = Duration.between(start, end);
        System.out.println("Time taken from redis controller: "+ timeElapsed.toMillis() +" milliseconds");
        return u;
    }

    @GetMapping
    @RequestMapping("/getUsers")
    public List<User> findAllUsers(){
              return userService.getAllUsers();
    }

    @GetMapping(value = "/test")
    public String test(){
        return "Working";
    }

}
