package xxx.petmanbe.board.dto.request;

import java.util.List;

import lombok.Getter;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.Tag;

@Getter
public class UpdateBoardRequestDto {
	private String boardTitle;
	private String boardContent;
	private String categoryName;
	private List<TagListResponseDto> tagList;
 }
