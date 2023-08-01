package xxx.petmanbe.board.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;

@Getter
@NoArgsConstructor
@ToString
public class AddBoardRequestDto {
	private String boardTitle;

	private String boardContent;

	private List<TagListResponseDto> tagList;

	private String nickname;

	private String shopTitle;

	private String categoryName;

	private List<String> fileUrlList;

	public Board toEntity(){
		return Board.builder()
			.boardTitle(this.boardTitle)
			.boardContent(this.boardContent)
			.build();
	}
}
