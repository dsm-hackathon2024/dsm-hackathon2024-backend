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
        private final String profile;

        public UserRank(String username, int score, String profile) {
            this.username = username;
            this.score = score;
            this.profile = profile;
        }
    }
}


