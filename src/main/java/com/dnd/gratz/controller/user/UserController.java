package com.dnd.gratz.controller.user;

import com.dnd.gratz.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    /**
     * 닉네임 중복 체크
     * @param nickname
     */
    @GetMapping("/user/check/")
    public void checkNickNameDuplicated(@RequestParam String nickname) {
        userService.checkNickNameDuplicated(nickname);
    }
}
