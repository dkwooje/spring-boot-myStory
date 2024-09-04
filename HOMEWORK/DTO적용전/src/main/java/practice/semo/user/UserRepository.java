package practice.semo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTable,Integer> {

    Optional<UserTable> findByUsername(String username);
}
