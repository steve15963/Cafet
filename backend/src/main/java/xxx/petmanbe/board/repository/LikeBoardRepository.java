package xxx.petmanbe.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.LikeBoard;

public interface LikeBoardRepository extends JpaRepository<LikeBoard, Long> {

	void deleteByBoard_BoardIdAndUser_UserId(Long boardId, Long userId);

	List<LikeBoard> findByUser_UserId(Long userId);

	Optional<LikeBoard> findByUser_UserIdAndBoard_boardId(Long userId, Long boardId);
}
