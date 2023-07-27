package xxx.petmanbe.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.board.entity.Category;

@Getter
@NoArgsConstructor
public class AddCategoryRequestDto {
	private String categoryName;

	// dto to entity
	public Category toEntity(){
		return Category.builder()
			.categoryName(this.categoryName)
			.build();
	}
}
