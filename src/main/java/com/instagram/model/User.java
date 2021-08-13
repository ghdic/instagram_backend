package com.instagram.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="User")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String userId;
    private String userName;
    private String name;
    private String profileImage;

    public User() {
        super();
    }

    public User(int id, String userId, String userName, String name, String profileImage) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
