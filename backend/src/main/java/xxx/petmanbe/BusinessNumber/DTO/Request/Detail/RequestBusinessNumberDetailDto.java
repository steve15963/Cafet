package xxx.petmanbe.BusinessNumber.DTO.Request.Detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestBusinessNumberDetailDto {
	RequestBusinessNumberBodyDto[] businesses;

	public RequestBusinessNumberDetailDto(RequestBusinessNumberBodyDto businesses) {
		this.businesses = new RequestBusinessNumberBodyDto[1];
		this.businesses[0] = businesses;

	}
}
