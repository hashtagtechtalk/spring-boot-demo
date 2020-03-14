package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.repository;

import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RedisUserRepository {

    public static final String USER = "USER";
    @Autowired
    private UserRepository userRepository;

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisUserRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(User user){
        userRepository.save(user);
        System.out.print(user.getUserId());
        hashOperations.put(USER, user.getUserId(), user);
    }
    public List<User> findAll(){
        return hashOperations.values(USER);
    }

    public User findById(int id){
        return (User) hashOperations.get(USER, id);
    }


    public void update(User user){
        userRepository.save(user);
        save(user);
    }

    public void delete(int id){
        userRepository.delete(findById(id));
        hashOperations.delete(USER, String.valueOf(id));
    }

}
