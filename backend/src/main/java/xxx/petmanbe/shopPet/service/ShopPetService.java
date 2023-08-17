package xxx.petmanbe.shopPet.service;

import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.request.PutShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;

public interface ShopPetService {

    GetShopPetDto getShopPet(long shopId);

    long postShopPet(PostShopPetDto postShopPetDto);

    void putShopPet(PutShopPetDto putShopPetDto);

    void deleteShopPet(Long shopPetId);

}
