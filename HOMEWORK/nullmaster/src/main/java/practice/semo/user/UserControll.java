package practice.semo.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserControll {

    private final UserRepository userRepository;
    private final UserService userService;


    @GetMapping("/user")
    String register1() {
        return "userpage.html";
    }

    @GetMapping("/register")
    String register2() {
        return "userRegister.html";
    }

    @PostMapping("/register")
    String register3(
            String username,
            String password,
            String email) {
        userService.addUser(username, password, email);
        return "userpage.html";
    }

    @GetMapping("/forcing")
    String register4() {
        return "userRegister10000.html";
    }


    @PostMapping("/forcing")
    String register5() {
        userService.createUser();
        return "userpage.html";

    }
}
