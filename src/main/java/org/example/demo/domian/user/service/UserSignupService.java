package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.request.SignupRequest;
import org.example.demo.domian.user.dto.response.TokenResponse;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.exception.UserAlreadyExistException;
import org.example.demo.domian.user.repository.UserRepository;
import org.example.demo.global.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SignupRequest request) {
        if(userRepository.existsById(request.getId())) throw UserAlreadyExistException.EXCEPTION;

        User user = userRepository.save(User.builder()
                        .id(request.getId())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }

}
