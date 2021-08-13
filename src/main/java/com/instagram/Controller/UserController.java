package com.instagram.Controller;

import com.instagram.Service.UserService;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    private User submitUser(@RequestBody User user) {
        return userService.submitMetaDataOfUser(user);
    }

    @GetMapping("/{userid}")
    private User getUsedrDetails(@PathVariable("userid") String userId) {
        System.out.println(userService.displayUserMetaData(userId));
        return userService.displayUserMetaData(userId);
    }
}
