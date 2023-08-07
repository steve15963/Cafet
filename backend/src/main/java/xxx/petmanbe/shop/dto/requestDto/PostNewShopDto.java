package xxx.petmanbe.shop.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostNewShopDto {

    String shopTitle;

    String address;

    String phoneNo;

    String descriptions;

    String openedTime;

    String closedTime;

    String sns;

    String homepage;

    long userId;


}
