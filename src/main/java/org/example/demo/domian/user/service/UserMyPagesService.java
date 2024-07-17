package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.response.UserMyPagesResponse;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.repository.UserRepository;
import org.example.demo.global.aws.S3Util;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMyPagesService {
    private final UserRepository userRepository;

    private final S3Util s3Util;


    public UserMyPagesResponse userMyPagesService(String userId) {

        User user = userRepository.findById(userId).orElseThrow();

        return new UserMyPagesResponse(user.getScore(), user.getId(), user.getUsername(), s3Util.getProfileImageUrl(user.getProfile()));

    }
}

