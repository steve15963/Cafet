package xxx.petmanbe.shopPet.dto.response;

import lombok.*;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shopPet.entity.ShopPet;

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


    public GetShopPetDto(ShopPet shopPet){
        this.shopPetId = shopPet.getShopPetId();
        this.petName = shopPet.getPetName();
        this.petAge = shopPet.getPetAge();
        this.gender = shopPet.getGender();
        this.species = shopPet.getSpecies();
        this.description = shopPet.getDescription();
        this.birth = shopPet.getBirth();
    }

}
