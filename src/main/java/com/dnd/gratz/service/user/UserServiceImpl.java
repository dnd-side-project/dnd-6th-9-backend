package com.dnd.gratz.service.user;

import com.dnd.gratz.db.entity.user.User;
import com.dnd.gratz.exception.UserNickNameAlreadyExistsException;
import com.dnd.gratz.repository.user.UserRepository;
import com.dnd.gratz.util.AuthenticationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationUtil authenticationUtil;
    private final UserRepository userRepository;

    @Override
    public void checkNickNameDuplicated(String nickName) {
        checkDuplicatedNickName(nickName);
    }

    private void checkDuplicatedNickName(String nickName) {
        userRepository.findByNickName(nickName).ifPresent(user -> {
            throw new UserNickNameAlreadyExistsException();
        });
    }

    @Override
    public void modifyNickName(String nickName) {
        checkDuplicatedNickName(nickName);
        User user = authenticationUtil.getUser();
        userRepository.save(user.update(nickName));
    }

    @Override
    public void deleteUser() {
        User user = authenticationUtil.getUser();
        userRepository.delete(user);
    }
}
