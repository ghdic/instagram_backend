package com.instagram.Repository;

import com.instagram.model.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepo extends CrudRepository<Comments, Integer> {

    Comments save(Comments comments);
    Comments findCommentsByCommentId(int commentId);
    ArrayList<Comments> findAllByPostId(int postId);
    void deleteCommentsByCommentId(int commentId);
}
