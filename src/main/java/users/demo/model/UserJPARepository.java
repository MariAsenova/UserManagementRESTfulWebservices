package users.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    // query to find user by name
    Optional<User> findUserByName(String name);
}
