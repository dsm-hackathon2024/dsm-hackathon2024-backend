package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.request.SigninRequest;
import org.example.demo.domian.user.dto.response.TokenResponse;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.facade.UserFacade;
import org.example.demo.global.security.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SigninRequest request){
        User user = userFacade.findByUserId(request.getId());
        userFacade.checkPassword(user, request.getPassword());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }

}
