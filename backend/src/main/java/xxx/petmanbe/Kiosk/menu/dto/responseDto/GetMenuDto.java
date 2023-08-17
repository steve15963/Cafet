package xxx.petmanbe.Kiosk.menu.dto.responseDto;

import lombok.*;
import xxx.petmanbe.Kiosk.menu.dto.other.GetMenuPriceSizeDto;
import xxx.petmanbe.Kiosk.menu.entity.Menu;
import xxx.petmanbe.Kiosk.menufile.entity.MenuFile;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetMenuDto {
    private Long menuId;

    private String menuType;

    private List<GetMenuPriceSizeDto> getMenuPriceSizeDtoList;

    private MenuFile menuFile;

    public GetMenuDto(Menu menu){
        this.menuType=menu.getMenuType();
        this.menuId=menu.getMenuId();
        this.getMenuPriceSizeDtoList=menu.getMenuPriceSize().stream()
                .map(GetMenuPriceSizeDto::new).collect(Collectors.toList());
        this.menuFile=menu.getMenuFile();

    }


}
