package practice.semo.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;



    @GetMapping("/user")
    String register1() {
        return "userpage.html";
    }

    @GetMapping("/user/register")
    String register2() {
        return "userRegister.html";
    }

    @PostMapping("/user/register")
    public String register3(
            String username,
            String password,
            String email) {
        userService.addUser(username, password, email);
        return "userpage.html";
    }

    @GetMapping("/user/login")
    public String login(String username ){
        var result = userRepository.findByUsername(username);
        return "userLogin.html";
    }

    @GetMapping("/mypage")
    public String myPage(Authentication auth) {
        System.out.println(auth);
        System.out.println(auth.getName());
        System.out.println(auth.isAuthenticated());
        return "mypage.html";
    }


}
