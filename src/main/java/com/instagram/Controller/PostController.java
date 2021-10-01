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

    @PostMapping("/{postId}")
    private Post updateUserPost(@PathVariable("postId") int postId,  @RequestBody String uid, @RequestBody String content, @RequestBody String postPath) {
        return postService.updatePostToDatabase(postId, uid, content, postPath);
    }

    @DeleteMapping("/{postId}")
    private int deleteUserPost(@PathVariable("postId") int postId, @RequestBody String uid) {
        return postService.deletePostToDatabase(postId, uid);
    }

    @GetMapping("/{uid}")
    private ArrayList<Post> getPostsByUser(@PathVariable("uid") String uid) {
        return postService.displayPostsByUser(uid);
    }
}
