package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue
    private int commentId;
    private int postId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name = "uid") // 멤버변수이름_외래키이름
    private User user;
    @Column(updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createDate;
    private String comment;

    public Comments() {
        super();
    }

    public Comments(int commentId, int postId, String uid, User user, LocalDateTime createDate, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.uid = uid;
        this.user = user;
        this.createDate = createDate;
        this.comment = comment;
    }
}
