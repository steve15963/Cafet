package xxx.petmanbe.shopPet.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostShopPetDto {

	private long shopId;

	private String petName;

	private int petAge;

	private String gender;

	private String description;

	private String birth;

}
