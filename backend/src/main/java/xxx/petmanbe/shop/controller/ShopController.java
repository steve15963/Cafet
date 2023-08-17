package xxx.petmanbe.shop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.address.repository.AddressRepository;
import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.LikeShopRequestDto;
import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;
import xxx.petmanbe.shop.service.GradeService;
import xxx.petmanbe.shop.service.ShopService;

@RestController
@RequestMapping(value="/api/shop")
@Tag(name = "가게", description = "가게 관련 API Docs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ShopController {

    private final ShopService shopService;

    private final GradeService gradeService;

    @Value("${kakao.map.key}")
    String key;

    // 가게 하나 가져오기
    @GetMapping("/{shopId}")
    @Operation(summary = "가게 정보 상세보기")
    public ResponseEntity<GetShopDto> getShop(@PathVariable long shopId){

        GetShopDto getShopDto = shopService.getShop(shopId);

        return new ResponseEntity<>(getShopDto, HttpStatus.OK);
    }

    //가게 추가하기
    @PostMapping("/new")
    @Operation(summary = "가게 추가하기")
    public ResponseEntity<String> PostShopNew(@RequestBody PostNewShopDto request) throws IOException {

        shopService.postShopNew(request);

        return new ResponseEntity<>("sucess",HttpStatus.OK);
    }

    //가게 수정하기
    @PutMapping("")
    @Operation(summary = "가게 수정하기")
    public ResponseEntity<String> PutShop(@RequestBody PutShopDto request){

        shopService.putShop(request);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

	//가게 삭제(soft-delete)
	@DeleteMapping("/status/{shopId}")
    @Operation(summary = "가게 정보 삭제/복구하기")
	public ResponseEntity<String> putBoardStatus(@PathVariable Long shopId){

        // 결과 전달
        shopService.putShopStatus(shopId);

        return new ResponseEntity<>("success", HttpStatus.NO_CONTENT);
	}

    // 가게 평점 주기
	@PostMapping("/grade")
    @Operation(summary = "가게 평점 주기")
	public ResponseEntity<String> PostShopGrade(@RequestBody PostShopGradeDto request){

        gradeService.postShopGrade(request);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    // 유저 별 가게 평점 조회하기
    @GetMapping("/grade/{shopId}/{userId}")
    @Operation(summary = "가게 평점 조회하기")
    public ResponseEntity<GetShopUserGradeDto> GetShopGrade(@PathVariable long shopId, @PathVariable long userId){

        GetShopUserGradeDto getShopUserGradeDto = gradeService.getShopGrade(shopId, userId);

        return new ResponseEntity<>(getShopUserGradeDto, HttpStatus.OK);

    }


    // 유저별 가게 평점 수정하기
    @PutMapping("/grade")
    @Operation(summary = "평점 수정하기")
    public ResponseEntity<String> PutShopGrade(@RequestBody PutShopGradeDto request){

        gradeService.putShopGrade(request);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    // 유저 별 가게 평점 삭제하기
    @DeleteMapping("/grade")
    @Operation(summary = "평점 삭제하기")
    public ResponseEntity<String> DeleteShopGrade(@RequestBody DeleteShopGradeDto request){

        gradeService.deleteShopGrade(request);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    // 전체 가게 보기
    @GetMapping("")
    @Operation(summary = "전체 가게보기")
    public ResponseEntity<List<GetShopListDto>> getShopList(){

        // 전체 가게 목록 가져오기
        List<GetShopListDto> shopList = shopService.getShopList();

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 관리자 기능: 가게 이름으로 검색
    @GetMapping("/shopTitle/{key}")
    @Operation(summary = "가게 이름으로 검색")
    public ResponseEntity<List<GetShopListDto>> getShopListByShopTitle(@PathVariable String key){

        List<GetShopListDto> shopList = shopService.getShopListByTitle(key);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 관리자 기능: 가게 주소로 검색
    @GetMapping("/address/{key}")
    @Operation(summary = "가게 주소로 검색")
    public ResponseEntity<List<GetShopListDto>> getShopListByAddress(@PathVariable String key){

        List<GetShopListDto> shopList = shopService.getShopListByAddress(key);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 가게 검색, 주소 또는 이름으로
    @GetMapping("/search/{key}")
    @Operation(summary = "가게 검색기능, 주소 또는 이름")
    public ResponseEntity<List<GetShopListDto>> getShopListByKey(@PathVariable String key){

        List<GetShopListDto> shopList = shopService.getShopListByKey(key,key);

        return new ResponseEntity<>(shopList, HttpStatus.OK);

    }

    // 해당 태그가 들어가는 가게 리스트 가져오기
    @GetMapping("/tag/{tagName}")
    @Operation(summary = "가게 검색기능, 태그로")
    public ResponseEntity<List<GetShopListDto>> getShopListByTag(String tagName){

        List<GetShopListDto> shopList = shopService.getShopListByTag(tagName);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 가게 찜하기
    @PostMapping("/like")
    @Operation(summary = "가게 찜하기")
    public ResponseEntity<Integer> postLikeShop(@RequestBody LikeShopRequestDto request){

        if (shopService.postLikeShop(request.getUserId(), request.getShopId())){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        throw new IllegalArgumentException();
    }

    // 사용자가 찜한 가게 목록 가져오기
    @GetMapping("/like/{userId}")
    @Operation(summary = "해당 사용자가 찜한 가게 목록 가져오기")
    public ResponseEntity<List<GetShopListDto>> getLikeShopListByUser(@PathVariable Long userId){

        List<GetShopListDto> shopList = shopService.getLikeShopListByUser(userId);

        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    // 가게 찜 취소하기
    @DeleteMapping("/like")
    @Operation(summary = "해당 가게 찜 취소하기")
    public ResponseEntity<Integer> deleteLikeShop(@RequestBody LikeShopRequestDto request){

        // 삭제가 되면
        if (shopService.deleteLikeShop(request.getUserId(), request.getShopId())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new IllegalArgumentException();
    }
}
