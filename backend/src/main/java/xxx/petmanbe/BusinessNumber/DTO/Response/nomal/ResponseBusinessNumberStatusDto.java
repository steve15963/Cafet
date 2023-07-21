package xxx.petmanbe.BusinessNumber.DTO.Response.nomal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseBusinessNumberStatusDto {
	String status_code;
	Integer match_cnt;
	Integer request_cnt;
	ResponseBusinessNumberStatusDataDto data[];
}
