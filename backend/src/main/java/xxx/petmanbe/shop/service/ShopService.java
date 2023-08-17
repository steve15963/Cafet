package xxx.petmanbe.shop.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import xxx.petmanbe.shop.dto.others.Position;
import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.entity.Shop;

public interface ShopService {

	// 가게 정보 조회하기
    public GetShopDto getShop(long shopId);
    
	// 가게 정보 추가하기
	public boolean postShopNew(PostNewShopDto postNewShopDto) throws IOException;

	// 가게 정보 수정하기
	public boolean putShop(PutShopDto putShopDto);

	// 가게 정보 삭제하기
	public boolean putShopStatus(Long shopId);


	List<GetShopListDto> getShopList();

	List<GetShopListDto> getShopListByTitle(String shopTitle);

	List<GetShopListDto> getShopListByAddress(String address);

	public Position addressToPosition(String address) throws IOException;

	public String getRoad(String address);

	// 태그에 맞는 가게 목록 가져오기
	List<GetShopListDto> getShopListByTag(String tagName);
	
	// 찜 생성하기
	boolean postLikeShop(Long userId, Long shopId);
	
	// 유저가 찜한 가게 목록 가져오기
	List<GetShopListDto> getLikeShopListByUser(Long userId);
	
	// 가게 찜 삭제
	boolean deleteLikeShop(Long userId, Long shopId);

	List<GetShopListDto> getShopListByKey(String address, String shopTitle);

}
