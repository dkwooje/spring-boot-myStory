package practice.semo.user;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public void addUser(String username,
                        String password,
                        String email){
        UserTable table = new UserTable();
        table.setUsername(username);
        table.setPassword(password);
        table.setEmail(email);
        userRepository.save(table);

    }


}
