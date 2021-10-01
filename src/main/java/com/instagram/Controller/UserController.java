package com.instagram.Controller;

import com.instagram.Service.UserService;
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
    private User updateUser(@PathVariable("uid") String uid, @RequestBody String userName, @RequestBody String nickName, @RequestBody String profileImage) {
        return userService.updateUserData(uid, userName, nickName, profileImage);
    }
}
