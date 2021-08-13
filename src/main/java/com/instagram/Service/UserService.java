package com.instagram.Service;

import com.instagram.Repository.UserRepo;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User submitMetaDataOfUser (User user) {
        return userRepo.save(user);
    }

    public User displayUserMetaData(String userId){
        return userRepo.findByUserId(userId);
    }
}
