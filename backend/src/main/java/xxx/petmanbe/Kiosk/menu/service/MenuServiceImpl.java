package xxx.petmanbe.Kiosk.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.Kiosk.menu.dto.other.PostMenuPriceSizeDto;
import xxx.petmanbe.Kiosk.menu.dto.requestDto.PostMenuDto;
import xxx.petmanbe.Kiosk.menu.dto.responseDto.GetMenuDto;
import xxx.petmanbe.Kiosk.menu.entity.Menu;
import xxx.petmanbe.Kiosk.menu.entity.MenuPriceSize;
import xxx.petmanbe.Kiosk.menu.repository.MenuPriceSizeRepository;
import xxx.petmanbe.Kiosk.menu.repository.MenuRepository;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	private final MenuRepository menuRepository;

	private final MenuPriceSizeRepository menuPriceSizeRepository;
	private final ShopRepository shopRepository;

	@Override
	public long postMenu(PostMenuDto postMenuDto) {

		Shop shop = shopRepository.findById(postMenuDto.getShopId())
			.orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

		Menu menu = Menu.builder()
				.menuType(postMenuDto.getMenuType())
				.shop(shop)
				.build();

		Menu menu_save = menuRepository.save(menu);

		for(PostMenuPriceSizeDto x : postMenuDto.getPostMenuPriceSizeDtoList()){

			MenuPriceSize menuPriceSize = MenuPriceSize.builder()
					.menuPrice(x.getMenuPrice())
					.menuSize(x.getMenuSize())
					.menu(menu_save)
					.build();

			menuPriceSizeRepository.save(menuPriceSize);
//			menuPriceSizeList
		}
//			menu_save.setMenuPriceSize();


//		long menuId = menuRepository.save(menu).getMenuId();

		return menu.getMenuId();
	}

	@Override
	public List<GetMenuDto> getMenu(long shopId) {

		return menuRepository.findAllByShop_shopId(shopId)
			.orElseThrow(()->new RestApiException(CommonErrorCode.INVALID_PARAMETER)).stream()
				.map(GetMenuDto::new)
				.collect(Collectors.toList());
	}


}
