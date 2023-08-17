package xxx.petmanbe.board.dto.request;

import java.util.List;

import lombok.Getter;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;

@Getter
public class UpdateBoardRequestDto {
	private Long boardId;
	private String boardTitle;
	private String boardContent;
	private String categoryName;
	private List<TagListResponseDto> tagList;
 }
