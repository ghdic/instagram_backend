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

    @GetMapping("/{userid}")
    private User getUsedrDetails(@PathVariable("userid") String userId) {
        return userService.displayUserMetaData(userId);
    }
}
