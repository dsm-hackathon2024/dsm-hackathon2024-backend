package org.example.demo.domian.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMyPagesResponse {
    int count;
    String id;
    String userId;

    @Builder
    public UserMyPagesResponse(int count, String id, String userId) {
        this.count = count;
        this.id = id;
        this.userId = userId;
    }
}
