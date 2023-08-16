package xxx.petmanbe.inquiry.service;

import java.util.List;

import xxx.petmanbe.inquiry.dto.request.AddInquiryRequestDto;
import xxx.petmanbe.inquiry.dto.response.InquiryListResponseDto;
import xxx.petmanbe.inquiry.dto.response.InquiryResponseDto;

public interface InquiryService {
	// 문의 생성
	void postInquiry(AddInquiryRequestDto request);

	// 문의 보기
	InquiryResponseDto getInquiry(Long inquiryId);

	// 문의 전체 목록보기
	List<InquiryListResponseDto> getInquiryList();

	// 문의 카테고리별 보기
	List<InquiryListResponseDto> getInquiryListByCategory(String categoryName);

	// 문의 삭제하기
	void deleteInquiry(Long inquiryId);
}
