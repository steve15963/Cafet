package xxx.petmanbe.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}