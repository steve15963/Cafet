package xxx.petmanbe.comment.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.comment.entity.Comment;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
	private Long commentId;
	private String content;
	// user와 연동시 resolve
	private String nickname;
	private LocalDateTime createdTime;
	private boolean status;

	@Builder
	// entity to dto
	public CommentResponseDto(Comment comment) {
		this.commentId = comment.getCommentId();
		this.content = comment.getContent();
		this.nickname = comment.getUser().getNickname();
		this.createdTime = comment.getCreatedTime();
		this.status = comment.isStatus();
	}
}
