package xxx.petmanbe.shopPet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ShopPetServiceImpl implements ShopPetService{

    private final ShopPetRepository shopPetRepository;

    @Transactional
    @Override
    public GetShopPetDto getShopPet(long shopId) {

        ShopPet shopPet = shopPetRepository.findByShop_ShopId(shopId).orElseThrow(()->new IllegalArgumentException());
        
        GetShopPetDto getShopPetDto = GetShopPetDto.builder()
                .petAge(shopPet.getPetAge())
                .petName(shopPet.getPetName())
                .gender(shopPet.getGender())
                .species(shopPet.getSpecies())
                .description(shopPet.getDescription())
                .birth(shopPet.getBirth())
                .build();

        return getShopPetDto;
    }

    @Override
    public boolean postShopPet(PostShopPetDto postShopPetDto) {

//        Sh = shopPetRepository.findByShop_ShopId()


        return false;
    }


}
