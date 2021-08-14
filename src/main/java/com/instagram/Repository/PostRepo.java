package com.instagram.Repository;

import com.instagram.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PostRepo extends CrudRepository<Post, Integer> {
    Post save(Post post);
    ArrayList<Post> findAll();
}
