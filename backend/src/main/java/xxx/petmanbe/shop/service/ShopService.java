package xxx.petmanbe.shop.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.entity.Shop;

public interface ShopService {
<<<<<<< backend/src/main/java/xxx/petmanbe/shop/service/ShopService.java
    GetShopDto getShop(long shopId);
    boolean postShopNew(PostNewShopDto postNewShopDto);
    boolean putShop(PutShopDto putShopDto);

	Shop putShopStatus(Long shopId);

	// List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName);


	// 가게 정보 조회하기
    public GetShopDto getShop(long shopId);
    
	// 가게 정보 추가하기
	public boolean postShopNew(PostNewShopDto postNewShopDto);

	// 가게 정보 수정하기
	public boolean putShop(PutShopDto putShopDto);

	// 가게 정보 삭제하기
	public Shop putShopStatus(Long shopId);

	public String addressToPosition(String address) throws IOException;

	// public List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName);

	List<GetShopListDto> getShopList();

	List<GetShopListDto> getShopListByTitle(String shopTitle);

	List<GetShopListDto> getShopListByAddress(String address);

}
