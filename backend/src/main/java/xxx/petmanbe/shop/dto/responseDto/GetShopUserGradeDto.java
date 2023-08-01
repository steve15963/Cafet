package xxx.petmanbe.shop.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shop.entity.Grade;

@Getter
@Setter
@NoArgsConstructor
public class GetShopUserGradeDto {

	private int value;

	public GetShopUserGradeDto(Grade grade){
		this.value = grade.getValue();
	}
}
