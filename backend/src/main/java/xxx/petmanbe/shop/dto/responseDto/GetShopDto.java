package xxx.petmanbe.shop.dto.responseDto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

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
public class GetShopDto {

	private long shopId;

	private String shopTitle;

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

}
