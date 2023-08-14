package xxx.petmanbe.Kiosk.menu.dto.requestDto;

import lombok.*;
import xxx.petmanbe.Kiosk.menu.dto.other.PostMenuPriceSizeDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostMenuDto {

	private long shopId;

	private String menuType;

	private List<PostMenuPriceSizeDto> postMenuPriceSizeDtoList;

}
