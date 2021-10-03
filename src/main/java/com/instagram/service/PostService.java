package com.instagram.service;

import com.instagram.repository.PostRepo;
import com.instagram.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserService userService;

    public Post submitPostToDataBase(Post post) {
        post.setUser(userService.displayUserMetaData(post.getUid()));
        post.setCreateDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        return postRepo.save(post);
    }

    public Post updatePostToDatabase(int postId, String uid, String content, String postPath) {
        Post post = postRepo.findPostByPostId(postId);
        if(post == null || !post.getUser().getUid().equals(uid))
            return null;
        post.setContent(content);
        post.setPostPath(postPath);
        postRepo.save(post);
        return post;
    }

    public int deletePostToDatabase(int postId, String uid) {
        Post post = postRepo.findPostByPostId(postId);
        if(post == null || !post.getUser().getUid().equals(uid))
            return -1;
        postRepo.deleteByPostId(postId);
        return 0;
    }

    public ArrayList<Post> retrivePostFromDB() {
        return postRepo.findAll(Sort.by(Sort.Direction.DESC, "postId"));
    }

    public ArrayList<Post> displayPostsByUser(String uid) {
        return postRepo.findPostsByUid(Sort.by(Sort.Direction.DESC, "id") ,uid);
    }
}
