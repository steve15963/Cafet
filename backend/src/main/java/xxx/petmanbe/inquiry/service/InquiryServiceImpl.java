package xxx.petmanbe.inquiry.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sun.security.jgss.InquireType;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.inquiry.dto.request.AddInquiryRequestDto;
import xxx.petmanbe.inquiry.dto.response.InquiryListResponseDto;
import xxx.petmanbe.inquiry.dto.response.InquiryResponseDto;
import xxx.petmanbe.inquiry.entity.Inquiry;
import xxx.petmanbe.inquiry.entity.InquiryCategory;
import xxx.petmanbe.inquiry.repository.InquiryCategoryRepository;
import xxx.petmanbe.inquiry.repository.InquiryRepository;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

	private final InquiryRepository inquiryRepository;
	private final InquiryCategoryRepository inquiryCategoryRepository;

	// 문의 생성
	@Override
	public void postInquiry(AddInquiryRequestDto request) {
		// 일단 entity 만들고
		Inquiry inquiry = request.toEntity();

		// 카테고리 가져오기
		InquiryCategory category = inquiryCategoryRepository.findByInquiryCategoryName(request.getInquiryCategory())
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

		// 카테고리 설정
		inquiry.setInquiryCategory(category);

		// 엔티티 영속
		inquiryRepository.save(inquiry);
	}

	// 문의 상세정보 가져오기
	@Override
	public InquiryResponseDto getInquiry(Long inquiryId) {
		// 문의 정보 id로 검색
		Inquiry inquiry = inquiryRepository.findById(inquiryId)
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

		// 반환하기
		return InquiryResponseDto.builder()
			.inquiry(inquiry)
			.build();
	}

	// 전체 문의 정보 가져오기
	@Override
	public List<InquiryListResponseDto> getInquiryList() {
		return inquiryRepository.findAll().stream()
			.map(InquiryListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 카테고리별 문의 정보 가져오기
	@Override
	public List<InquiryListResponseDto> getInquiryListByCategory(String categoryName) {
		return inquiryRepository.findByInquiryCategory_InquiryCategoryName(categoryName).stream()
			.map(InquiryListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 문의 삭제하기
	@Override
	public void deleteInquiry(Long inquiryId) {
		// id로 정보 찾고
		Inquiry inquiry = inquiryRepository.findById(inquiryId)
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));
		
		// 해당하는 문의 삭제
		inquiryRepository.delete(inquiry);
	}
}
