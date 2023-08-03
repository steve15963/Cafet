package xxx.petmanbe.shopPet.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetShopPetDto {

    private String petName;

    private String petAge;

    private String gender;

    private String species;

    private String description;

    private String birth;

}
