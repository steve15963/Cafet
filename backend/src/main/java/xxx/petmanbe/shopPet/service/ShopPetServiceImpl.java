package xxx.petmanbe.shopPet.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.PetErrorCode;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.request.PutShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;
import xxx.petmanbe.shopPetFile.dto.ShopPetFileDto;
import xxx.petmanbe.shopPetFile.entity.ShopPetFile;
import xxx.petmanbe.shopPetFile.repository.ShopPetFileRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ShopPetServiceImpl implements ShopPetService{

    private final ShopPetRepository shopPetRepository;

    private final ShopRepository shopRepository;

    private final ShopPetFileRepository shopPetFileRepository;

    @Transactional
    @Override
    public GetShopPetDto getShopPet(long shopPetId) {

        ShopPet shopPet = shopPetRepository.findById(shopPetId)
            .orElseThrow(()-> new RestApiException(PetErrorCode.PET_NOT_FOUND));

        List<ShopPetFile> shopPetFile = shopPet.getShopPetFileList();
        List<ShopPetFileDto> shopPetFileDtoList = null;

        if(!Objects.isNull(shopPetFile)){
            shopPetFileDtoList = shopPetFile
                .stream()
                .map(ShopPetFileDto::new).collect(Collectors.toList());
        }

		return GetShopPetDto.builder()
                .shopPetId(shopPet.getShopPetId())
                .petAge(shopPet.getPetAge())
                .petName(shopPet.getPetName())
                .gender(shopPet.getGender())
                .species(shopPet.getSpecies())
                .description(shopPet.getDescription())
                .birth(shopPet.getBirth())
            .shopPetFileDtoList(shopPetFileDtoList)
                .build();
    }

    @Transactional
    @Override
    public long postShopPet(PostShopPetDto postShopPetDto) {

        Shop shop = shopRepository.findById(postShopPetDto.getShopId())
            .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

        ShopPet shopPet = ShopPet.builder()
            .shop(shop)
            .petName(postShopPetDto.getPetName())
            .gender(postShopPetDto.getGender())
            .species(postShopPetDto.getGender())
            .petAge(postShopPetDto.getPetAge())
            .description(postShopPetDto.getDescription())
            .birth(postShopPetDto.getBirth())
            .build();

        shop.getShopPetList().add(shopPet);

        shopPetRepository.save(shopPet);

        shopRepository.save(shop);

        return shopPet.getShopPetId();
    }

    @Transactional
    @Override
    public boolean putShopPet(PutShopPetDto putShopPetDto) {

        ShopPet shopPet = shopPetRepository.findById(putShopPetDto.getShopPetId())
            .orElseThrow(()-> new RestApiException(PetErrorCode.PET_NOT_FOUND));

        shopPet.updateShopPet(putShopPetDto);

        shopPetRepository.save(shopPet);

        return true;
    }

    @Transactional
    @Override
    public boolean deleteShopPet(Long shopPetId) {

        ShopPet shopPet = shopPetRepository.findById(shopPetId)
            .orElseThrow(()->new RestApiException(PetErrorCode.PET_NOT_FOUND));

        shopPet.changeDeleteStatus();

        shopPetRepository.save(shopPet);

        return true;
    }
}
