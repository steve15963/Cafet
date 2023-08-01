package xxx.petmanbe.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.shop.dto.requestDto.*;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.service.GradeService;
import xxx.petmanbe.shop.service.ShopService;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value="/api/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    private final GradeService gradeService;

	//지역별로 찾기
	// @GetMapping("/list/{sidoName}/{gugunName}/{dongName}")
	// public ResponseEntity<List<Shop>> GetShopRegionList(@PathVariable String sidoName, String gugunName, String dongName){
	//
	// 	List<Shop> shop = shopService.getShopRegionList(sidoName, gugunName, dongName);
	//
	// 	return new ResponseEntity<>(shop,HttpStatus.OK);
	// }


    @GetMapping("/{shopId}")
    public ResponseEntity<GetShopDto> GetShop(@PathVariable long shopId){

        GetShopDto getShopDto = shopService.getShop(shopId);

        return new ResponseEntity<>(getShopDto, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> PostShopNew(@RequestBody PostNewShopDto request){

        if(shopService.postShopNew(request)){
            return new ResponseEntity<>("sucess",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("유저 status가 낮습니다.",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("")
    public ResponseEntity<String> PutShop(@RequestBody PutShopDto request){

        if(shopService.putShop(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }

    }


	//삭제(soft-delete)
	@DeleteMapping("/status/{shopId}")
	public ResponseEntity<Integer> putBoardStatus(@PathVariable Long shopId){
		// 삭제 상태로 전환
		shopService.putShopStatus(shopId);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/grade")
	public ResponseEntity<String> PostShopGrade(@RequestBody PostShopGradeDto request){

        if(gradeService.postShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/grade")
    public ResponseEntity<Long> GetShopGrade(@RequestBody GetShopGradeDto request){

        long gradeId = gradeService.getShopGrade(request);

        return new ResponseEntity<>(gradeId, HttpStatus.OK);

        // if(gradeService.getShopGrade(request)){
        // 	return new ResponseEntity<>("success", HttpStatus.OK);
        // }else{
        // 	return new ResponseEntity<>("fail",HttpStatus.OK);
        // }


    }

    @PutMapping("/grade")
    public ResponseEntity<String> PutShopGrade(@RequestBody PutShopGradeDto request){

        if(gradeService.putShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/grade")
    public ResponseEntity<String> DeleteShopGrade(@RequestBody DeleteShopGradeDto request){

        if(gradeService.deleteShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }

    }

}
