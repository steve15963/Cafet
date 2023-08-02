package xxx.petmanbe.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.LikeBoard;

public interface LikeBoardRepository extends JpaRepository<LikeBoard, Long> {

	int countByBoard_BoardIdAndUser_UserId(Long boardId, Long userId);

	void deleteByBoard_BoardIdAndUser_UserId(Long boardId, Long userId);
}
