package xxx.petmanbe.board.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.board.entity.Board;

@Getter
@NoArgsConstructor
public class BoardListResponseDto {
	private Long boardId;
	private String boardTitle;
	private String nickname;
	private String categoryName;
	// 좋아요 생성시 resolve
	private int likeSum;
	private int commentSum;
	private int viewCnt;
	private LocalDateTime createdTime;
	private boolean status;

	@Builder
	// entity to dto
	public BoardListResponseDto(Board board) {
		this.boardId = board.getBoardId();
		this.boardTitle = board.getBoardTitle();
		this.nickname = board.getUser().getNickname();
		this.categoryName = board.getCategory().getCategoryName();
		this.likeSum = board.getLikeSum();
		this.viewCnt = board.getViewCnt();
		this.commentSum = board.getCommentSum();
		this.createdTime = board.getCreatedTime();
		this.status = board.isStatus();
	}
}
