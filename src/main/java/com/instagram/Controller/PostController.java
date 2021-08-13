package com.instagram.Controller;

import com.instagram.Service.PostService;
import com.instagram.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("")
    private Post submitUserPost(@RequestBody Post post) {
        return postService.submitPostToDataBase(post);
    }

    @GetMapping("")
    private ArrayList<Post> getAllPost() {
        return postService.retrivePostFromDB();
    }
}
