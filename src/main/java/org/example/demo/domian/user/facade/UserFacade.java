package org.example.demo.domian.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.demo.domian.user.entity.User;
import org.example.demo.domian.user.exception.PasswordMismatchException;
import org.example.demo.domian.user.exception.UserNotFoundException;
import org.example.demo.domian.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void checkPassword(User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    public User findByUserId(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getCurrentUser () {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUserId(id);
    }
}