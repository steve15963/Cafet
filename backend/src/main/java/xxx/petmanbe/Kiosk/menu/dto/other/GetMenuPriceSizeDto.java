package xxx.petmanbe.Kiosk.menu.dto.other;

import lombok.*;
import xxx.petmanbe.Kiosk.menu.entity.MenuPriceSize;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetMenuPriceSizeDto {

    private int menuPrice;

    private String menuSize;

    public GetMenuPriceSizeDto(MenuPriceSize menuPriceSize){
        this.menuPrice = menuPriceSize.getMenuPrice();
        this.menuSize = menuPriceSize.getMenuSize();
    }

//    public GetMenuPriceSizeDto(MenuPriceSize menuPriceSize) {
//    }
}
