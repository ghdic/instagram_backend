package com.instagram.Repository;

import com.instagram.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    Post save(Post post);
    Post findPostByPostId(int postId);
    ArrayList<Post> findAll(Sort sort);
    ArrayList<Post> findPostsByUid(Sort sort, String uid);
    void deleteByPostId(int postId);
}
