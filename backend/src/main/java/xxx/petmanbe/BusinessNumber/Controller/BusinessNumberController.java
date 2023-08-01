package xxx.petmanbe.BusinessNumber.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
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
	@GetMapping("/simple/{num}")
	public ResponseEntity<String> simpleBusinessNumJoin(@PathVariable String num) {
		if (businessNumberService.CheckBsuinessNumber(num)) {
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}

	/**
	 * 사업자 번호의 정보를 추가적으로 받아 일치하는지 검사하는 API
	 * @since 2023-07-15
	 * @param num 사업자번호
	 * @param startDt 개업일
	 * @param name 대표자이름
	 * @return 200 : 있는 사업자 번호, 400 : 없는 사업자 번호
	 */
	@GetMapping("/detail/{num}/{startDt}/{name}")
	public ResponseEntity<String> detailBusinessNumJoin(@PathVariable String num, @PathVariable String startDt,
		@PathVariable String name) {
		if (businessNumberService.CheckBsuinessNumber(num, startDt, name)) {
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}
}
