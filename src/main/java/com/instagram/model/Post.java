package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name="Post")
public class Post {
    @Id
    @GeneratedValue
    private int postId;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name = "uid") // 멤버변수이름_외래키이름
    private User user;
    private String content;
    @Column(length = 1024)
    private String postPath;
    @Column(updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ColumnDefault("0")
    private int likeCount;

    public Post() {
        super();
    }

    public Post(int postId, String uid, User user, String content, String postPath, LocalDateTime createDate, int likeCount) {
        this.postId = postId;
        this.uid = uid;
        this.user = user;
        this.content = content;
        this.postPath = postPath;
        this.createDate = createDate;
        this.likeCount = likeCount;
    }
}
