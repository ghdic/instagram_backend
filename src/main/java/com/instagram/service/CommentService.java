package com.instagram.service;

import com.instagram.repository.CommentRepo;
import com.instagram.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserService userService;

    public Comments submitCommentToDB(Comments comment) {
        comment.setUser(userService.displayUserMetaData(comment.getUid()));
        comment.setCreateDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        return commentRepo.save(comment);
    }

    public Comments updateCommentToDB(int commentId, String uid, String comment) {
        Comments comments = commentRepo.findCommentsByCommentId(commentId);
        if(comments == null || !comments.getUser().getUid().equals(uid))
            return null;
        comments.setComment(comment);
        commentRepo.save(comments);
        return comments;
    }

    public int deleteCommentToDB(int commentId, String uid) {
        Comments comments = commentRepo.findCommentsByCommentId(commentId);
        if(comments == null || !comments.getUser().getUid().equals(uid))
            return -1;
        commentRepo.deleteCommentsByCommentId(commentId);
        return 0;
    }

    public ArrayList<Comments> getAllCommentsForDB(int postId) {
        return commentRepo.findAllByPostId(postId);
    }


}
