package xxx.petmanbe.board.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import xxx.petmanbe.board.entity.Board;

@Getter
@NoArgsConstructor
@ToString
public class AddBoardRequestDto {
	private String boardTitle;

	private String boardContent;

	// user와 mapping 이후 resolve
	// private String nickname;

	// shop과 mapping 이후 resolve
	// private String shopName;

	// category 생성 이후 resolve
	// private String categoryName;

	public Board toEntity(){
		return Board.builder()
			.boardTitle(this.boardTitle)
			.boardContent(this.boardContent)
			.build();
	}
}
