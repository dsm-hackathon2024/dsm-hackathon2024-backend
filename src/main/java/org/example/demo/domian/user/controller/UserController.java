package org.example.demo.domian.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.request.SigninRequest;
import org.example.demo.domian.user.dto.request.SignupRequest;
import org.example.demo.domian.user.dto.response.TokenResponse;
import org.example.demo.domian.user.dto.response.UserMyPagesResponse;
import org.example.demo.domian.user.dto.response.UserRankList;
import org.example.demo.domian.user.repository.UserRepository;
import org.example.demo.domian.user.service.QueryUserRankService;
import org.example.demo.domian.user.service.UploadProfileService;
import org.example.demo.domian.user.service.UserLoginService;
import org.example.demo.domian.user.service.UserMyPagesService;
import org.example.demo.domian.user.service.UserSignupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserLoginService userLoginService;
    private final UserSignupService userSignupService;
    private final QueryUserRankService queryUserRankService;
    private final UserMyPagesService userMyPagesService;
    private final UploadProfileService uploadProfileService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) { return userSignupService.execute(request); }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signin")
    public TokenResponse login(@RequestBody @Valid SigninRequest request){
        return userLoginService.execute(request);
    }

    @GetMapping("/rank")
    public UserRankList rank() { return queryUserRankService.execute(); }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/mypages/{userId}")
    public UserMyPagesResponse myPages(@PathVariable String userId){
        return userMyPagesService.userMyPagesService(userId);
    }

    @PatchMapping(value = "/profile", consumes = {"multipart/form-data"})
    public void profile(@RequestPart(value = "image", required = false) MultipartFile file) {uploadProfileService.execute(file);  }
}
