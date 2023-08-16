package xxx.petmanbe.inquiry.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.inquiry.entity.Inquiry;

@Getter
@NoArgsConstructor
public class InquiryResponseDto {
	private Long inquiryId;
	private String inquiryTitle;
	private String inquiryContent;
	private String inquiryCategoryName;
	private String nickname;
	private String email;
	private String phoneNo;
	private LocalDateTime createdTime;

	// entity to dto
	@Builder
	public InquiryResponseDto(Inquiry inquiry){
		this.inquiryId = inquiry.getInquiryId();
		this.inquiryTitle = inquiry.getInquiryTitle();
		this.inquiryContent = inquiry.getInquiryContent();
		this.inquiryCategoryName = inquiry.getInquiryCategory().getInquiryCategoryName();
		this.nickname = inquiry.getNickname();
		this.email = inquiry.getEmail();
		this.phoneNo = inquiry.getPhoneNo();
		this.createdTime = inquiry.getCreatedTime();
	}
}
