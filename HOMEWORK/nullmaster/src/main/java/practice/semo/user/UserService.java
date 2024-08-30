package practice.semo.user;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public void addUser(String username,
                        String password,
                        String email) {
        UserTable table = new UserTable();
        table.setUsername(username);
        table.setPassword(password);
        table.setEmail(email);
        userRepository.save(table);

    }


    public void createUser() {
        List<UserTable> users = new ArrayList<>();


        for (int i = 0; i < 10000; i++) {
            UserTable user = new UserTable();
            user.setUsername("user" + i);
            user.setPassword("Q1W2E3R4" + i);
            user.setEmail("durjvnr" + i + "@naver.com");
            users.add(user);

            // 배치로 데이터 삽입 (500개씩 저장)
            if (i % 500 == 0) {
                userRepository.saveAll(users);
                userRepository.flush();
                users.clear();
            }
        }

        // 남아 있는 데이터 저장
        if (!users.isEmpty()) {
            userRepository.saveAll(users);
        }
    }
}