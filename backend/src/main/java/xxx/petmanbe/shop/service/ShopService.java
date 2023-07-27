package xxx.petmanbe.shop.service;

import java.util.List;
import java.util.Optional;

import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;

public interface ShopService {
    public GetShopDto getShop(long shopId);
    public boolean postShopNew(PostNewShopDto postNewShopDto);
    public boolean putShop(PutShopDto putShopDto);

	public Shop putShopStatus(Long shopId);

	// public List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName);



}
