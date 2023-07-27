package xxx.petmanbe.comment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.comment.entity.Comment;

@Getter
@NoArgsConstructor
public class AddCommentRequestDto {
	private String content;

	public Comment toEntity(){
		return Comment.builder()
			.content(this.content)
			.build();
	}
}
