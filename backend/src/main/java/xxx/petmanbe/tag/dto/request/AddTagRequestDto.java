package xxx.petmanbe.tag.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.tag.entity.Tag;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagRequestDto {
	private String tagName;

	// dto to entity
	public Tag toEntity(){
		return Tag.builder()
			.tagName(this.tagName)
			.build();
	}
}
