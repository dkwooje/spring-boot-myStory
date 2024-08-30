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



    @GetMapping("/register")
    String register1(){
        return "userRegister.html";
    }

    @PostMapping("/register")
    String register2(
                    String username,
                    String password,
                    String email){
        userService.addUser(username, password, email);
        return "userRegister.html";
    }



}
