package com.dnd.gratz.util;

import com.dnd.gratz.db.entity.user.User;
import com.dnd.gratz.exception.UserNotAuthenticatedException;
import com.dnd.gratz.exception.UserNotFoundException;
import com.dnd.gratz.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class AuthenticationUtil {

    private final UserRepository userRepository;

    public String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new UserNotAuthenticatedException();
        }
        return authentication.getName();
    }

    public User getUser() {
        return userRepository.findByEmail(getUserEmail()).orElseThrow(UserNotFoundException::new);
    }
}
