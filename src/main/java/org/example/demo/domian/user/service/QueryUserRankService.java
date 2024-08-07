package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.response.UserRankList;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.repository.UserRepository;
import org.example.demo.global.aws.S3Util;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryUserRankService {
    private final UserRepository userRepository;
    private final S3Util s3Util;

    @Transactional(readOnly = true)
    public UserRankList execute() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));

        List<UserRankList.UserRank> userRanks = users.stream()
                .map(it -> UserRankList.UserRank.builder()
                        .username(it.getUsername())
                        .score(it.getScore())
                        .profile(s3Util.getProfileImageUrl(it.getProfile()))
                        .build()).toList();

        return UserRankList.builder()
                .userLinkList(userRanks)
                .build();
    }
}
