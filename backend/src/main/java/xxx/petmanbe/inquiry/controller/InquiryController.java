package xxx.petmanbe.inquiry.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.inquiry.dto.request.AddInquiryRequestDto;
import xxx.petmanbe.inquiry.dto.response.InquiryListResponseDto;
import xxx.petmanbe.inquiry.dto.response.InquiryResponseDto;
import xxx.petmanbe.inquiry.service.InquiryService;

@RestController
@RequestMapping("/api/inquiry")
@RequiredArgsConstructor
@CrossOrigin("*")
public class InquiryController {
	private final InquiryService inquiryService;

	// 문의 생성
	@PostMapping("")
	public ResponseEntity<Integer> postInquiry(@RequestBody AddInquiryRequestDto request){

		// 문의 만들기
		inquiryService.postInquiry(request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 문의 상세 보기
	@GetMapping("/{inquiryId}")
	public ResponseEntity<InquiryResponseDto> getInquiry(@PathVariable Long inquiryId){

		// 해당하는 문의 가져오기
		InquiryResponseDto inquiry = inquiryService.getInquiry(inquiryId);

		// 결과 전달
		return new ResponseEntity<>(inquiry, HttpStatus.OK);
	}


	// 문의 전체 보기
	@GetMapping("")
	public ResponseEntity<List<InquiryListResponseDto>> getInquiryList(){

		// 전체 문의 리스트 가져오기
		List<InquiryListResponseDto> inquiryList = inquiryService.getInquiryList();

		// 결과 전달
		return new ResponseEntity<>(inquiryList, HttpStatus.OK);
	}

	// 카테고리별 문의 모아보기
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<List<InquiryListResponseDto>> getInquiryListByCategory(@PathVariable String categoryName){

		// 카테고리에 해당하는 문의 리스트 가져오기
		List<InquiryListResponseDto> inquiryList = inquiryService.getInquiryListByCategory(categoryName);

		// 결과 전달
		return new ResponseEntity<>(inquiryList, HttpStatus.OK);
	}

	// 문의 삭제
	@DeleteMapping("/{inquiryId}")
	public ResponseEntity<Integer> deleteInquiry(@PathVariable Long inquiryId){

		// 문의 삭제하기
		inquiryService.deleteInquiry(inquiryId);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
