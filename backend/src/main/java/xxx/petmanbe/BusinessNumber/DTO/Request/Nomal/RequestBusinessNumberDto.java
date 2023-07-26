package xxx.petmanbe.BusinessNumber.DTO.Request.Nomal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestBusinessNumberDto {
	String b_no[];

	public RequestBusinessNumberDto(String BusinessNumber) {
		b_no = new String[1];
		b_no[0] = BusinessNumber;
	}
}
