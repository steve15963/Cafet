package xxx.petmanbe.shopPet.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPetFile.dto.ShopPetFileDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetShopPetDto {

    private Long shopPetId;

    private String petName;

    private int petAge;

    private String gender;

    private String species;

    private String description;

    private String birth;

    private List<ShopPetFileDto> shopPetFileDtoList;

    public GetShopPetDto(ShopPet shopPet){
        this.shopPetId = shopPet.getShopPetId();
        this.petName = shopPet.getPetName();
        this.petAge = shopPet.getPetAge();
        this.gender = shopPet.getGender();
        this.species = shopPet.getSpecies();
        this.description = shopPet.getDescription();
        this.birth = shopPet.getBirth();
        this.shopPetFileDtoList = shopPet.getShopPetFileList().stream().map(ShopPetFileDto::new).collect(Collectors.toList());
    }

}
