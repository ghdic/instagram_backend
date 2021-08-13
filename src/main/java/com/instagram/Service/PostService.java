package com.instagram.Service;

import com.instagram.Repository.PostRepo;
import com.instagram.model.Post;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserService userService;

    public Post submitPostToDataBase(Post post) {
        Post result = postRepo.save(post);
        User user = userService.displayUserMetaData(post.getUserId());
        if(user != null) {
            result.setUserName(user.getUserName());
        }
        return result;
    }

    public ArrayList<Post> retrivePostFromDB() {
        ArrayList<Post> postArrayList = postRepo.findAll();

        for(int i = 0; i < postArrayList.size(); i++) {
            Post post = postArrayList.get(i);
            User user = userService.displayUserMetaData(post.getUserId());
            if(user != null) {
                post.setUserName(user.getUserName());
            }
        }
        Collections.sort(postArrayList, (a, b)->b.getId()-a.getId());
        return postArrayList;
    }
}
