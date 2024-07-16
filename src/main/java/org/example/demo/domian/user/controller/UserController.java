package org.example.demo.domian.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.request.SigninRequest;
import org.example.demo.domian.user.dto.request.SignupRequest;
import org.example.demo.domian.user.dto.response.TokenResponse;
import org.example.demo.domian.user.service.UserLoginService;
import org.example.demo.domian.user.service.UserSignupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserLoginService userLoginService;
    private final UserSignupService userSignupService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) { return userSignupService.execute(request); }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signin")
    public TokenResponse login(@RequestBody @Valid SigninRequest request){
        return userLoginService.execute(request);
    }
}
