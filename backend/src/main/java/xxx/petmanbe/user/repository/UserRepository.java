package xxx.petmanbe.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByNickname(String nickname);

	List<User> findUsersByEmailContaining(String email);

	List<User> findUsersByNicknameContaining(String nickname);
}

