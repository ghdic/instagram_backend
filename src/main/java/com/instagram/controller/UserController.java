package com.instagram.controller;

import com.instagram.message.request.UserProfileReq;
import com.instagram.service.UserService;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    private User submitUser(@RequestBody User user) {
        return userService.submitMetaDataOfUser(user);
    }

    @GetMapping("")
    private ArrayList<User> getAllUser() {
        return userService.getAllUserData();
    }

    @GetMapping("/{uid}")
    private User getUserDetails(@PathVariable("uid") String uid) {
        return userService.displayUserMetaData(uid);
    }

    @PostMapping("/{uid}")
    private User updateUser(@PathVariable("uid") String uid, @RequestBody UserProfileReq userProfile) {
        return userService.updateUserData(uid, userProfile.getUserName(), userProfile.getNickName(), userProfile.getProfileImage());
    }

    @GetMapping("/suggestions")
    private ArrayList<User> suggetionUsers() {
        return userService.getRecentlyRegisterUser();
    }
}
