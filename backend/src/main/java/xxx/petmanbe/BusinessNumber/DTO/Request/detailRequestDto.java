package xxx.petmanbe.BusinessNumber.DTO.Request;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class detailRequestDto {
	public String num;
	public String startDt;
	public String CEOName;
}