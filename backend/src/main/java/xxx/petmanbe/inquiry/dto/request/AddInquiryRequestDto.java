package xxx.petmanbe.inquiry.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.inquiry.entity.Inquiry;

@Getter
@NoArgsConstructor
public class AddInquiryRequestDto {
	private String inquiryTitle;
	private String inquiryContent;
	private String inquiryCategory;
	private String nickname;
	private String email;
	private String phoneNo;

	// dto to entity
	public Inquiry toEntity(){
		return Inquiry.builder()
			.inquiryTitle(this.inquiryTitle)
			.inquiryContent(this.inquiryContent)
			.nickname(this.inquiryCategory)
			.email(this.email)
			.phoneNo(this.phoneNo)
			.build();
	}
}
