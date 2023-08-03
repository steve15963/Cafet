package xxx.petmanbe.shop.service;

import java.util.List;
import java.util.Optional;

import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;

public interface ShopService {

	// 가게 정보 조회하기
    public GetShopDto getShop(long shopId);
    
	// 가게 정보 추가하기
	public boolean postShopNew(PostNewShopDto postNewShopDto);

	// 가게 정보 수정하기
	public boolean putShop(PutShopDto putShopDto);

	// 가게 정보 삭제하기
	public Shop putShopStatus(Long shopId);

	// public List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName);



}
