package xxx.petmanbe.shopPetFile.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shopPetFile.entity.ShopPetFile;

@Getter
@Setter
@NoArgsConstructor
public class ShopPetFileDto {

	String url;

	public ShopPetFileDto(ShopPetFile shopPetFile){
		this.url = shopPetFile.getUrl();

	}




}
