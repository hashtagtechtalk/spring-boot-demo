package com.hashtag.techtalk.springbootdemo.com.hashtag.techtalk.model;

import javassist.SerialVersionUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity(name = "user")
@Table(name = "usersTable")
public class User implements Serializable {

    public static final Long SerialVersionUID = 1L;

    @Id
    private int userId;
    @NotNull
    private String name;

    private String profession;

    private int instaFollowers;

    public User() {
    }

    public User(int userId, @NotNull String name, String profession, int instaFollowers) {
        this.userId = userId;
        this.name = name;
        this.profession = profession;
        this.instaFollowers = instaFollowers;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getInstaFollowers() {
        return instaFollowers;
    }

    public void setInstaFollowers(int instaFollowers) {
        this.instaFollowers = instaFollowers;
    }
}
