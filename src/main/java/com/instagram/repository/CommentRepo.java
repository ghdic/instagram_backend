package com.instagram.repository;

import com.instagram.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Integer> {

    Comments save(Comments comments);
    Comments findCommentsByCommentId(int commentId);
    ArrayList<Comments> findAllByPostId(int postId);
    @Transactional
    void deleteCommentsByCommentId(int commentId);
}
