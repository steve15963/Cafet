package xxx.petmanbe.board.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.board.entity.Board;

@Getter
@Setter
@NoArgsConstructor
public class BoardListResponseDto {
	private Long boardId;
	private String boardTitle;
	private String boardContent;
	private String thumbnail;
	private String nickname;
	private String categoryName;
	private int likeSum;
	private int commentSum;
	private int viewCnt;
	private boolean status;
	private LocalDateTime createdTime;

	@Builder
	// entity to dto
	public BoardListResponseDto(Board board) {
		this.boardId = board.getBoardId();
		this.boardTitle = board.getBoardTitle();
		this.boardContent = board.getBoardContent();
		this.thumbnail = board.getThumbnail();
		this.nickname = board.getUser().getNickname();
		this.categoryName = board.getCategory().getCategoryName();
		this.likeSum = board.getLikeSum();
		this.viewCnt = board.getViewCnt();
		this.status = board.isStatus();
		this.commentSum = board.getCommentSum();
		this.createdTime = board.getCreatedTime();
	}
}
