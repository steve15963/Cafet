package xxx.petmanbe.Kiosk.menu.service;

import xxx.petmanbe.Kiosk.menu.dto.requestDto.PostMenuDto;
import xxx.petmanbe.Kiosk.menu.dto.responseDto.GetMenuDto;

import java.util.List;

public interface MenuService {

	public long postMenu(PostMenuDto postMenuDto);

	public List<GetMenuDto> getMenu(long shopId);
}
