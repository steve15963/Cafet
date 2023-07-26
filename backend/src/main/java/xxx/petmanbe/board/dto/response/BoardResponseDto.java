package xxx.petmanbe.board.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
	private String boardTitle;
	private String boardContent;
	// user와 mapping 이후 resolve
	// private String nickname;

	// shop과 mapping 이후 resolve
	// private String shopTitle;

	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	private boolean status;
	// 좋아요 기능 생성시 resolve
	// private int likeSum;
	private List<CommentResponseDto> commentList;

	// entity to dto
	public BoardResponseDto(Board board){
		this.boardTitle = board.getBoardTitle();
		this.boardContent = board.getBoardContent();
		this.createdTime = board.getCreatedTime();
		this.updatedTime = board.getUpdatedTime();
		this.status = board.isStatus();
		this.commentList = board.getCommentList().stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}
}
