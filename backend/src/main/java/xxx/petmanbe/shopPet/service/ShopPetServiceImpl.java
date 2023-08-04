package xxx.petmanbe.shopPet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ShopPetServiceImpl implements ShopPetService{

    private final ShopPetRepository shopPetRepository;

    private final ShopRepository shopRepository;

    @Transactional
    @Override
    public GetShopPetDto getShopPet(long shopPetId) {

        ShopPet shopPet = shopPetRepository.findByShop_ShopId(shopPetId).orElseThrow(()->new IllegalArgumentException());
        
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

        Shop shop = shopRepository.findById(postShopPetDto.getShopId()).orElseThrow(()-> new IllegalArgumentException());

        ShopPet shopPet = ShopPet.builder()
            .shopPetId(postShopPetDto.getShopId())
            .petName(postShopPetDto.getPetName())
            .gender(postShopPetDto.getGender())
            .species(postShopPetDto.getGender())
            .petAge(postShopPetDto.getPetAge())
            .description(postShopPetDto.getDescription())
            .birth(postShopPetDto.getBirth())
            .build();

        shopRepository.save(shop);

        return true;
    }
    // 가게 별



}
