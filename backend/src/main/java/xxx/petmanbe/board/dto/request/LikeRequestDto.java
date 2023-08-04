package xxx.petmanbe.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeRequestDto {
	private Long boardId;
	private Long userId;
}
