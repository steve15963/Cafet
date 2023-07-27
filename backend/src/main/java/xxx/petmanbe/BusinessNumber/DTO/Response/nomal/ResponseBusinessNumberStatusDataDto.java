package xxx.petmanbe.BusinessNumber.DTO.Response.nomal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseBusinessNumberStatusDataDto {
	String b_no;
	String b_stt;
	String b_stt_cd;
	String tax_type;
	String tax_type_cd;
	String end_dt;
	String utcc_yn;
	String tax_type_change_dt;
	String invoice_apply_dt;
	String rbf_tax_type;
	String rbf_tax_type_cd;
}
