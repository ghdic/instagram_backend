package com.instagram.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name="User")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String uid;
    private String userName;
    private String nickName;
    @ColumnDefault("")
    private String profileImage;

    public User() {
        super();
    }

    public User(String uid, String userName, String nickName, String profileImage) {
        this.uid = uid;
        this.userName = userName;
        this.nickName = nickName;
        this.profileImage = profileImage;
    }
}
