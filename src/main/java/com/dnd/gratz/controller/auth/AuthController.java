package com.dnd.gratz.controller.auth;

import com.dnd.gratz.dto.request.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final HttpSession httpSesion;

    @GetMapping("/gratz")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSesion.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getNickName());
        }
        return "index";
    }
}
