package xxx.petmanbe.BusinessNumber.DTO.Request.Detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestBusinessNumberBodyDto {
	String b_no;
	String start_dt;
	String p_nm;
	String p_nm2;
	String b_nm;
	String corp_no;
	String b_sector;
	String b_type;
	String b_adr;

	public RequestBusinessNumberBodyDto(String b_no, String start_dt, String p_nm) {
		this.b_no = b_no;
		this.start_dt = start_dt;
		this.p_nm = p_nm;
	}
}
