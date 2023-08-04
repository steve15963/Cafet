package xxx.petmanbe.shop.controller;

import java.util.List;

import java.io.IOException;

import lombok.RequiredArgsConstructor;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.shop.dto.requestDto.*;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;
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

    @Value("${kakao.map.key}")
    String key;

	//지역별로 찾기
	// @GetMapping("/list/{sidoName}/{gugunName}/{dongName}")
	// public ResponseEntity<List<Shop>> GetShopRegionList(@PathVariable String sidoName, String gugunName, String dongName){
	//
	// 	List<Shop> shop = shopService.getShopRegionList(sidoName, gugunName, dongName);
	//
	// 	return new ResponseEntity<>(shop,HttpStatus.OK);
	// }

    @GetMapping("address/{address}")
    public ResponseEntity<String> GetAdress(@PathVariable String address) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet getRequest = new HttpGet("https://dapi.kakao.com/v2/local/search/address.json?query="+address);
        getRequest.addHeader("Authorization",key);

        HttpResponse response = client.execute(getRequest);

        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);

        System.out.println(body);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    // 가게 하나의 리스트 가져오기
    @GetMapping("/{shopId}")
    public ResponseEntity<GetShopDto> GetShop(@PathVariable long shopId){

        GetShopDto getShopDto = shopService.getShop(shopId);

        return new ResponseEntity<>(getShopDto, HttpStatus.OK);
    }

    //가게 추가하기
    @PostMapping("/new")
    public ResponseEntity<String> PostShopNew(@RequestBody PostNewShopDto request){

        if(shopService.postShopNew(request)){
            return new ResponseEntity<>("sucess",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("유저 status가 낮습니다.",HttpStatus.BAD_REQUEST);
        }
    }

    //가게 수정하기
    @PutMapping("")
    public ResponseEntity<String> PutShop(@RequestBody PutShopDto request){

        if(shopService.putShop(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }

    }


	//가게 삭제(soft-delete)
	@DeleteMapping("/status/{shopId}")
	public ResponseEntity<Integer> putBoardStatus(@PathVariable Long shopId){
		// 삭제 상태로 전환
		shopService.putShopStatus(shopId);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}

    // 가게 평점 주기
	@PostMapping("/grade")
	public ResponseEntity<String> PostShopGrade(@RequestBody PostShopGradeDto request){

        if(gradeService.postShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }
    }

    // 유저 별 가게 평점 조회하기
    @GetMapping("/grade/{shopId}/{userId}")
    public ResponseEntity<GetShopUserGradeDto> GetShopGrade(@PathVariable long shopId, @PathVariable long userId){

        GetShopUserGradeDto getShopUserGradeDto = gradeService.getShopGrade(shopId, userId);

        return new ResponseEntity<>(getShopUserGradeDto, HttpStatus.OK);

    }


    // 유저별 가게 평점 수정하기
    @PutMapping("/grade")
    public ResponseEntity<String> PutShopGrade(@RequestBody PutShopGradeDto request){

        if(gradeService.putShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }
    }

    // 유저 별 가게 평점 삭제하기
    @DeleteMapping("/grade")
    public ResponseEntity<String> DeleteShopGrade(@RequestBody DeleteShopGradeDto request){

        if(gradeService.deleteShopGrade(request)){
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }

    }

    // 전체 가게 보기
    @GetMapping("")
    public ResponseEntity<List<GetShopListDto>> getShopList(){

        // 전체 가게 목록 가져오기
        List<GetShopListDto> shopList = shopService.getShopList();

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 관리자 기능: 가게 이름으로 검색
    @GetMapping("/shopTitle/{key}")
    public ResponseEntity<List<GetShopListDto>> getShopListByShopTitle(@PathVariable String key){

        List<GetShopListDto> shopList = shopService.getShopListByTitle(key);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 관리자 기능: 가게 주소로 검색
    @GetMapping("/address/{key}")
    public ResponseEntity<List<GetShopListDto>> getShopListByAddress(@PathVariable String key){

        List<GetShopListDto> shopList = shopService.getShopListByAddress(key);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }
}
