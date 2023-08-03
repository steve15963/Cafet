package xxx.petmanbe.shop.dto.responseDto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shop.entity.Shop;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetShopDto {

    private long shopId;

    private String shopTitle;

    private long totalScore;

    private int gradeCount;

    private double longitude;

    private double latitude;

    private String address;

    private String phoneNo;

    private String descriptions;

    private String openedTime;

    private String closedTime;

    private String sns;

    private String homepage;

    // entity to dto
    public GetShopDto (Shop shop){
        this.shopId = shop.getShopId();
        this.shopTitle = shop.getShopTitle();
        this.gradeCount = shop.getGradeCount();
        this.longitude = shop.getLongitude();
        this.address = shop.getAddress();
        this.phoneNo = shop.getPhoneNo();
        this.descriptions = shop.getDescriptions();
        this.openedTime = shop.getOpenedTime();
        this.closedTime = shop.getClosedTime();
        this.sns = shop.getSns();
        this.homepage = shop.getHomepage();
    }
}
