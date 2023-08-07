package xxx.petmanbe.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shop.service.ShopService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {


    private final ShopService shopService;

    private final ShopRepository shopRepository;

    public List<Shop> GetShopbyMap(String sidoName, String gugunName){

        List<Shop> list = shopRepository




        return list;
    }



}
