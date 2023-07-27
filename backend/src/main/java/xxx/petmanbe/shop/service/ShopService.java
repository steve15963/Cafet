package xxx.petmanbe.shop.service;

import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;

public interface ShopService {

	public GetShopDto getShop(long shopId);

	public boolean postShopNew(PostNewShopDto postNewShopDto);

	public boolean putShop(PutShopDto putShopDto);

}
