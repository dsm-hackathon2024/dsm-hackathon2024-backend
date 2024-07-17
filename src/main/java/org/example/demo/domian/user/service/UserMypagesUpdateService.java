package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.dto.request.UserMyPagesUpdateRequest;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.facade.UserFacade;
import org.example.demo.domian.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMypagesUpdateService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    @Transactional
    public void UpdateMyPages(UserMyPagesUpdateRequest request){
        User user = userFacade.getCurrentUser();
        user.updateUsername(request.getUsername());
    }

}
