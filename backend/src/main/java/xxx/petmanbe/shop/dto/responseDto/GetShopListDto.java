package xxx.petmanbe.shop.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.shop.entity.Shop;

@Getter
@NoArgsConstructor
public class GetShopListDto {

	private long shopId;

	private String shopTitle;

	private int gradeCount;

	private String address;

	private String phoneNo;

	// entity to dto
	public GetShopListDto (Shop shop){
		this.shopId = shop.getShopId();
		this.shopTitle = shop.getShopTitle();
		this.gradeCount = shop.getGradeCount();
		this.address = shop.getAddress();
		this.phoneNo = shop.getPhoneNo();
	}
}
