package xxx.petmanbe.BusinessNumber.DTO.Response.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseBusinessNumberStatusDetailDto {
	String status_code;
	Integer request_cnt;
	Integer valid_cnt;
	ResponseBusinessNumberStatusDetailDataDto[] data;
}
