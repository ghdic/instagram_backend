package com.instagram.message.request;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
public class UserProfileReq {
    private String userName;
    private String nickName;
    private String profileImage;
}
