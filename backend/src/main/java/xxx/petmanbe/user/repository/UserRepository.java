package xxx.petmanbe.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public User findByUserId(long userId);

	List<UserListDto> findAllBy();
}