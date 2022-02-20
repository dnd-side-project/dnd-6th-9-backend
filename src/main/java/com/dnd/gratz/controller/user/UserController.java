package com.dnd.gratz.controller.user;

import com.dnd.gratz.controller.BaseController;
import com.dnd.gratz.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController extends BaseController {

    private final UserService userService;

    /**
     * 닉네임 중복 체크
     * @param nickName
     */
    @GetMapping("/user/check/")
    public void checkNickNameDuplicated(@RequestParam String nickName) {
        userService.checkNickNameDuplicated(nickName);
    }

    /**
     * 닉네임 변경
     * @param nickName
     */
    @PatchMapping("/user")
    public void modifyNickName(@RequestParam String nickName) {
        userService.modifyNickName(nickName);
    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping("/user")
    public void deleteUser() {
        userService.deleteUser();
    }
}
