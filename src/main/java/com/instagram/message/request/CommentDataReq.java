package com.instagram.message.request;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class CommentDataReq {
    private String uid;
    private String comment;
}
