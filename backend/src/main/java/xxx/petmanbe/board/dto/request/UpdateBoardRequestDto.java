package xxx.petmanbe.board.dto.request;

import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {
	private String boardTitle;
	private String boardContent;
	// category 생성 후 resolve
	// private String categoryName;
}
