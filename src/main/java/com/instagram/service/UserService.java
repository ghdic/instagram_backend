package com.instagram.service;


import com.instagram.message.request.UserProfileReq;
import com.instagram.repository.UserRepo;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User submitMetaDataOfUser (User user) {
        return userRepo.save(user);
    }

    public ArrayList<User> getAllUserData() {
        return userRepo.findAll();
    }

    public ArrayList<User> getRecentlyRegisterUser() {
        return userRepo.findFirst10ByOrderByIdDesc();
    }

    public User displayUserMetaData(String uid){
        return userRepo.findByUid(uid);
    }

    public User updateUserData(String uid, String userName, String nickName, String profileImage) {
        User user = userRepo.findByUid(uid);

        if(user == null)
            return null;

        user.setUserName(userName);
        user.setNickName(nickName);
        user.setProfileImage(profileImage);

        userRepo.save(user);
        return user;
    }
}
