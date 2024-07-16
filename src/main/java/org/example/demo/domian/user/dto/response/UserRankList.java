package org.example.demo.domian.user.dto.response;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserRankList {
    private final List<UserRank> userLinkList;

    @Builder
    @Getter
    public static class UserRank {
        private final String username;
        private final int score;

        public UserRank(String username, int score) {
            this.username = username;
            this.score = score;
        }
    }
}


