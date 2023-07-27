package xxx.petmanbe.tag.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.tag.entity.Attach;
import xxx.petmanbe.tag.entity.Tag;

@Getter
@NoArgsConstructor
public class AttachListResponseDto {
	private Board board;
	private Tag tag;

	// entity to dto
	public AttachListResponseDto (Attach attach){
		this.board = attach.getBoard();
		this.tag = attach.getTag();
	}
}
