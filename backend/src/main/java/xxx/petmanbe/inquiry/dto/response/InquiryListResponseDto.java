package xxx.petmanbe.inquiry.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.inquiry.entity.Inquiry;

@Getter
@NoArgsConstructor
public class InquiryListResponseDto {
	private Long inquiryId;
	private String inquiryTitle;
	private String inquiryCategoryName;
	private String nickname;
	private LocalDateTime createdTime;

	// entity to dto
	@Builder
	public InquiryListResponseDto(Inquiry inquiry){
		this.inquiryId = inquiry.getInquiryId();
		this.inquiryTitle = inquiry.getInquiryTitle();
		this.inquiryCategoryName = inquiry.getInquiryCategory().getInquiryCategoryName();
		this.nickname = inquiry.getNickname();
		this.createdTime = inquiry.getCreatedTime();
	}
}
