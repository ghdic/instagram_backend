package com.instagram.Service;

import com.instagram.Repository.CommentRepo;
import com.instagram.model.Comments;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserService userService;

    public Comments submitCommentToDB(Comments comment) {
        Comments result = commentRepo.save(comment);
        User user = userService.displayUserMetaData(result.getUserId());
        if(user != null) {
            result.setUserName(user.getUserName());
        }
        return result;
    }

    public ArrayList<Comments> getAllCommentsForDB(String postId) {
        ArrayList<Comments> commentsArrayList = commentRepo.findAllByPostId(postId);

        for(int i = 0; i < commentsArrayList.size(); i++) {
            Comments comment = commentsArrayList.get(i);
            User user = userService.displayUserMetaData(comment.getUserId());
            if(user != null) {
                comment.setUserName(user.getUserName());
            }
        }
        return commentsArrayList;
    }
}
