package org.example.demo.domian.user.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserScoreService {
    private final UserFacade userFacade;

    @Transactional
    public void scoreCountService() {
        User user = userFacade.getCurrentUser();
        user.scoreCount();
    }
}
