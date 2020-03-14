package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.repository;

import com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
