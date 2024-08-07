package org.example.demo.domian.user.entity;

import lombok.AccessLevel;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @Column(unique = true, nullable = false, length = 12)
    private String id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false)
    private int score = 0;

    private String profile;

    @Builder
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public String profile(String file) {
        this.profile = file;
        return this.profile;
    }
    public void updateUsername(String username ){
        this.username = username;

    }

    public void scoreCount(int level) {
        this.score += level;
    }
}
