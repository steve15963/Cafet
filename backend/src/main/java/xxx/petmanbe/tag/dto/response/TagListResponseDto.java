package xxx.petmanbe.tag.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.tag.entity.Tag;

@Getter
@NoArgsConstructor
public class TagListResponseDto {
	private Long tagId;
	private String tagName;

	// entity to dto
	public TagListResponseDto (Tag tag){
		this.tagId = tag.getTagId();
		this.tagName = tag.getTagName();
	}
}
