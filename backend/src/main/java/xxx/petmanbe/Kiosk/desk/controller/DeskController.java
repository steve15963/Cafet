package xxx.petmanbe.Kiosk.desk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostFirstDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PutTableDto;
import xxx.petmanbe.Kiosk.desk.dto.resquestDto.GetDeskDto;
import xxx.petmanbe.Kiosk.desk.service.DeskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/desk")
@Tag(name = "키오스크 있는 테이블", description = "가게 테이블 API Docs")
@CrossOrigin("*")
public class DeskController {

    private final DeskService deskService;

    @GetMapping("/{shopId}")
    @Operation(summary = "테이블 정보 가져오기")
    public ResponseEntity<?> GetDesk(@PathVariable long shopId){

        List<GetDeskDto> getDeskDto = deskService.GetShopDesk(shopId);

        return new ResponseEntity<>(getDeskDto, HttpStatus.OK);

    }

    //처음에 한번에 여러개 만드는 것
    @PostMapping("/first")
    @Operation(summary = "테이블 생성 - 초기설정")
    public ResponseEntity<?> PostFirstDesk(@RequestBody PostFirstDeskDto request){

        boolean check = deskService.postFirstShop(request);

        if(!check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PostMapping("")
    @Operation(summary = "테이블 생성")
    public ResponseEntity<?> PostDesk(@RequestBody PostDeskDto request){

        boolean check = deskService.postShop(request);

        if(!check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    //이것 좀 고민해봐야함.
    @DeleteMapping("/{shopId}/{tableNum}")
    @Operation(summary = "테이블 삭제")
    public ResponseEntity<?> DeleteDesk(@PathVariable long shopId, @PathVariable long tableNum){

        boolean check = deskService.deleteDesk(shopId, tableNum);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{shopId}/{tableNum}")
    @Operation(summary = "테이블 수정")
    public ResponseEntity<?> PutDesk(@PathVariable long shopId, @PathVariable long tableNum , @RequestBody PutTableDto putTableDto){

        boolean check = deskService.putDesk(shopId, tableNum, putTableDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
