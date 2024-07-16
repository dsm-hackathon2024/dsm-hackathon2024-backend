package org.example.demo.domian.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMyPagesResponse {
    int count;
    String id;
    String userId;
    String profile;

    @Builder
    public UserMyPagesResponse(int count, String id, String userId, String profile) {
        this.count = count;
        this.id = id;
        this.userId = userId;
        this.profile = profile;
    }
}
