package xxx.petmanbe.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByStatusFalse();

	List<Board> findByStatusFalseAndBoardTitleContaining(String boardTitle);

	List<Board> findByStatusFalseAndBoardContentContaining(String boardContent);

	List<Board> findByStatusFalseAndUser_Nickname(String nickname);

	List<Board> findByStatusFalseAndCategory_CategoryId(Long categoryId);

	List<Board> findByStatusFalseAndShop_ShopId(Long shopId);
}
