package xxx.petmanbe.userfile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.userfile.entity.UserFile;

public interface UserFileRepository extends JpaRepository<UserFile, Long> {

	List<UserFile> findUserFileByUser_UserId(Long userId);

}
