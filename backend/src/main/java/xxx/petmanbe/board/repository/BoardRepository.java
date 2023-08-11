package xxx.petmanbe.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByStatusFalseOrderByBoardIdDesc();

	List<Board> findByStatusFalseAndThumbnailNotNullOrderByBoardIdDesc();

	List<Board> findByStatusFalseAndBoardTitleContainingOrderByBoardIdDesc(String boardTitle);

	List<Board> findByStatusFalseAndBoardContentContainingOrderByBoardIdDesc(String boardContent);

	List<Board> findByStatusFalseAndUser_UserIdOrderByBoardIdDesc(Long userId);

	List<Board> findByStatusFalseAndUser_NicknameOrderByBoardIdDesc(String nickname);

	List<Board> findByStatusFalseAndCategory_CategoryIdOrderByBoardIdDesc(Long categoryId);

	List<Board> findByStatusFalseAndShop_ShopIdOrderByBoardIdDesc(Long shopId);
}
