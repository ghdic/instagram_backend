package com.instagram.controller;

import com.instagram.message.request.PostDataReq;
import com.instagram.message.request.UidReq;
import com.instagram.service.PostService;
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
    private Post updateUserPost(@PathVariable("postId") int postId, @RequestBody PostDataReq postDataReq) {
        return postService.updatePostToDatabase(postId, postDataReq.getUid(), postDataReq.getContent(), postDataReq.getPostPath());
    }

    @DeleteMapping("/{postId}")
    private int deleteUserPost(@PathVariable("postId") int postId, @RequestBody UidReq uidReq) {
        return postService.deletePostToDatabase(postId, uidReq.getUid());
    }

    @GetMapping("/{uid}")
    private ArrayList<Post> getPostsByUser(@PathVariable("uid") String uid) {
        return postService.displayPostsByUser(uid);
    }

    @PostMapping("/like/{postId}")
    private Post likeCountIncrease(@PathVariable("postId") int postId) {
        return postService.likeCountUpdate(postId);
    }
}
