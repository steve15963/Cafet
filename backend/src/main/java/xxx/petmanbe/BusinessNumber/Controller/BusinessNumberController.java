package xxx.petmanbe.BusinessNumber.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xxx.petmanbe.BusinessNumber.DTO.Request.detailRequestDto;
import xxx.petmanbe.BusinessNumber.DTO.Request.simpleRequestDto;
import xxx.petmanbe.BusinessNumber.Service.BusinessNumberService;

@RestController
@RequestMapping("/business/num")
@AllArgsConstructor
public class BusinessNumberController {
	private BusinessNumberService businessNumberService;

	/**
	 * 사업자 번호의 유무를 검사하는 API
	 * @since 2023-07-15
	 * @param num 사업자 번호
	 * @return 200 : 있는 사업자 번호, 400 : 없는 사업자 번호
	 */
	@GetMapping("/simple")
	public ResponseEntity<String> simpleBusinessNumJoin(@RequestBody simpleRequestDto requestDto) {
		if (businessNumberService.CheckBsuinessNumber(requestDto.getNum())) {
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}

	/**
	 * 사업자 번호의 정보를 추가적으로 받아 일치하는지 검사하는 API
	 * @since 2023-07-15
	 * @param requestDto 사업자 정보 객체
	 * @return 200 : 있는 사업자 번호, 400 : 없는 사업자 번호
	 */
	@GetMapping("/detail")
	public ResponseEntity<String> detailBusinessNumJoin(@RequestBody detailRequestDto requestDto) {
		if (businessNumberService.CheckBsuinessNumber(requestDto.getNum(), requestDto.getStartDt(), requestDto.getCEOName())) {
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}
}
