package xxx.petmanbe.BusinessNumber.DTO.Response.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xxx.petmanbe.BusinessNumber.DTO.Request.Detail.RequestBusinessNumberBodyDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDataDto;

@Getter
@Setter
@ToString
public class ResponseBusinessNumberStatusDetailDataDto {
	String b_no;
	String valid;
	String valid_msg;
	RequestBusinessNumberBodyDto request_param;
	ResponseBusinessNumberStatusDataDto status;
}
