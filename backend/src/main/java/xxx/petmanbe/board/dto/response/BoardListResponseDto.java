package xxx.petmanbe.board.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.board.entity.Board;

@Getter
@NoArgsConstructor
public class BoardListResponseDto {
	private String boardTitle;
	// user와 mapping 이후 resolve
	// private String nickname
	// shop과 mapping 이후 resolve
	// private String shopTitle;
	private LocalDateTime createdTime;
	private boolean status;
	// 좋아요 생성시 resolve
	// private int likeSum;

	// entity to dto
	public BoardListResponseDto(Board board) {
		this.boardTitle = board.getBoardTitle();
		this.createdTime = board.getCreatedTime();
		this.status = board.isStatus();
	}
}
