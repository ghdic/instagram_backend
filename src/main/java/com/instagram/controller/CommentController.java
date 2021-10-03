package com.instagram.controller;

import com.instagram.message.request.CommentDataReq;
import com.instagram.message.request.UidReq;
import com.instagram.service.CommentService;
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
    private Comments updateComments(@PathVariable("commentId") int commentId, @RequestBody CommentDataReq commentDataReq) {
        return commentService.updateCommentToDB(commentId, commentDataReq.getUid(), commentDataReq.getComment());
    }

    @DeleteMapping("/{commentId}")
    private int deleteComents(@PathVariable("commentId") int commentId, @RequestBody UidReq uidReq) {
        return commentService.deleteCommentToDB(commentId, uidReq.getUid());
    }
}
