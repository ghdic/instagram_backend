package com.instagram.repository;

import com.instagram.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    Post save(Post post);
    Post findPostByPostId(int postId);
    ArrayList<Post> findAll(Sort sort);
    ArrayList<Post> findPostsByUser_Uid(Sort sort, String user_uid);
    @Transactional
    void deleteByPostId(int postId);
}
