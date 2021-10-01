package com.instagram.Controller;

import com.instagram.Service.CommentService;
import com.instagram.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("")
    private Comments submitComment(@RequestBody Comments comment) {
        return commentService.submitCommentToDB(comment);
    }

    @GetMapping("/{postId}")
    private ArrayList<Comments> getCommentsForPost(@PathVariable("postId")int postId) {
        return commentService.getAllCommentsForDB(postId);
    }

    @PostMapping("/{commentId}")
    private Comments updateComments(@PathVariable("commentId") int commentId, @RequestBody String uid, @RequestBody String content) {
        return commentService.updateCommentToDB(commentId, uid, content);
    }

    @DeleteMapping("/{commentId}")
    private int deleteComents(@PathVariable("commentId") int commentId, @RequestBody String uid) {
        return commentService.deleteCommentToDB(commentId, uid);
    }
}
