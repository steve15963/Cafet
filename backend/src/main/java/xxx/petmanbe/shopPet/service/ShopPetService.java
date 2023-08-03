package xxx.petmanbe.shopPet.service;

import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;

public interface ShopPetService {

    public GetShopPetDto getShopPet(long shopId);

    public boolean postShopPet(PostShopPetDto postShopPetDto);

}
