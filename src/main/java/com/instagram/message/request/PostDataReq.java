package com.instagram.message.request;

import lombok.Data;

@Data
public class PostDataReq {
    private String uid;
    private String content;
    private String postPath;
}