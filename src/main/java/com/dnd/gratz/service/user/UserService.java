package com.dnd.gratz.service.user;

public interface UserService {
    void checkNickNameDuplicated(String nickName);
    void modifyNickName(String nickName);
    void deleteUser();
}
