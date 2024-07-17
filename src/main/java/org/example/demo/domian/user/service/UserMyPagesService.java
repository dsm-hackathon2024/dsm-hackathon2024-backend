package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.response.UserMyPagesResponse;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.exception.UserNotFoundException;
import org.example.demo.domian.user.facade.UserFacade;
import org.example.demo.domian.user.repository.UserRepository;
import org.example.demo.global.aws.S3Util;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMyPagesService {
    private final S3Util s3Util;
    private final UserFacade userFacade;

    public UserMyPagesResponse userMyPagesService(){
        User user = userFacade.getCurrentUser();

        return new UserMyPagesResponse(user.getScore(), user.getId(), user.getUsername(), s3Util.getProfileImageUrl(user.getProfile()));
    }
}

