package hu.nje.townsapp.controller.auth;

import hu.nje.townsapp.model.User;
import hu.nje.townsapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           @RequestParam("role") String role) {

        user.setRole(role);   // USER or ADMIN selected by button
        userService.register(user);

        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


}
