package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.facade.UserFacade;
import org.example.demo.global.aws.S3Util;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UploadProfileService {
    private final S3Util s3Util;
    private final UserFacade userFacade;

    @Transactional
    public void execute(MultipartFile file) {
        User user = userFacade.getCurrentUser();
        if (user.getProfile() != null) s3Util.delete(user.getProfile());

        user.profile(s3Util.upload(file));
    }
}
