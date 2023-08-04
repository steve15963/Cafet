package xxx.petmanbe.shopPet.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutShopPetDto {

	private long shopPetId;

	private String petName;

	private int petAge;

	private String gender;

	private String species;

	private String description;

	private String birth;

}
