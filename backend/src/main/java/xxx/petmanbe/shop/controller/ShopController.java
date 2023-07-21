package xxx.petmanbe.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.GetShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.service.GradeService;
import xxx.petmanbe.shop.service.ShopService;

@RestController
@RequestMapping(value="/api/shop")
@RequiredArgsConstructor
public class ShopController {

	private final ShopService shopService;

	private final GradeService gradeService;


	// @GetMapping("/list")
	// public ResponseEntity<String> GetShopList(@RequestBody ){
	//
	//
	//
	//
	// }

	@GetMapping("/{shopId}")
	public ResponseEntity<GetShopDto> GetShop(@PathVariable long shopId){

		GetShopDto getShopDto = shopService.getShop(shopId);

		return new ResponseEntity<>(getShopDto, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<String> PostShopNew(@RequestBody PostNewShopDto postNewShopDto){

		if(shopService.postShopNew(postNewShopDto)){
			return new ResponseEntity<>("sucess",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("")
	public ResponseEntity<String> PutShop(@RequestBody PutShopDto putShopDto){

		if(shopService.putShop(putShopDto)){
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/grade")
	public ResponseEntity<String> PostShopGrade(@RequestBody PostShopGradeDto postShopGradeDto){

		if(gradeService.postShopGrade(postShopGradeDto)){
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/grade")
	public ResponseEntity<Long> GetShopGrade(@RequestBody GetShopGradeDto getShopGradeDto){

		long gradeId = gradeService.getShopGrade(getShopGradeDto);

		return new ResponseEntity<>(gradeId, HttpStatus.OK);
		
		// if(gradeService.getShopGrade(getShopGradeDto)){
		// 	return new ResponseEntity<>("success", HttpStatus.OK);
		// }else{
		// 	return new ResponseEntity<>("fail",HttpStatus.OK);
		// }


	}

	@PutMapping("/grade")
	public ResponseEntity<String> PutShopGrade(@RequestBody PutShopGradeDto putShopGradeDto){

		if(gradeService.putShopGrade(putShopGradeDto)){
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/grade")
	public ResponseEntity<String> DeleteShopGrade(@RequestBody DeleteShopGradeDto deleteShopGradeDto){

		if(gradeService.deleteShopGrade(deleteShopGradeDto)){
			return new ResponseEntity<>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}

	}

}
