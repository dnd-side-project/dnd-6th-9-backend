package com.dnd.gratz.service.user;

import com.dnd.gratz.exception.UserNickNameAlreadyExistsException;
import com.dnd.gratz.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void checkNickNameDuplicated(String nickName) {
        userRepository.findByNickName(nickName).ifPresent(user -> {
            throw new UserNickNameAlreadyExistsException();
        });
    }
}
