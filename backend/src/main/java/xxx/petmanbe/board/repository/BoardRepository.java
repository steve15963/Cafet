package xxx.petmanbe.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByStatusFalse();

	List<Board> findByBoardTitleContaining(String boardTitle);

	List<Board> findByBoardContentContaining(String boardContent);
}
