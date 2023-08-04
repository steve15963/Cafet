package xxx.petmanbe.shop.service;

import java.util.List;
import java.util.Optional;

import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.entity.Shop;

public interface ShopService {
    GetShopDto getShop(long shopId);
    boolean postShopNew(PostNewShopDto postNewShopDto);
    boolean putShop(PutShopDto putShopDto);

	Shop putShopStatus(Long shopId);

	// List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName);

	List<GetShopListDto> getShopList();

	List<GetShopListDto> getShopListByTitle(String shopTitle);

	List<GetShopListDto> getShopListByAddress(String address);

}
