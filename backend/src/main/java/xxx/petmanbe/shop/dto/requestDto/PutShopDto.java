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
public class PutShopDto {

	long shopId;

	String shopTitle;

	long totalScore;

	int gradeCount;

	double longitude;

	double latitude;

	String address;

	String phoneNo;

	String descriptions;

	String openedTime;

	String closedTime;

	String sns;

	String homepage;

}
