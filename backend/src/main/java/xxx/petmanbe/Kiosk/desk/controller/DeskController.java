package xxx.petmanbe.Kiosk.desk.controller;

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
@CrossOrigin("*")
public class DeskController {

    private final DeskService deskService;

    @GetMapping("/{shopId}")
    public ResponseEntity<?> GetDesk(@PathVariable long shopId){

        List<GetDeskDto> getDeskDto = deskService.GetShopDesk(shopId);

        return new ResponseEntity<>(getDeskDto, HttpStatus.OK);

    }

    //처음에 한번에 여러개 만드는 것
    @PostMapping("/first")
    public ResponseEntity<?> PostFirstDesk(@RequestBody PostFirstDeskDto request){

        boolean check = deskService.postFirstShop(request);

        if(!check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PostMapping("")
    public ResponseEntity<?> PostDesk(@RequestBody PostDeskDto request){

        boolean check = deskService.postShop(request);

        if(!check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    //이것 좀 고민해봐야함.
    @DeleteMapping("/{shopId}/{tableNum}")
    public ResponseEntity<?> DeleteDesk(@PathVariable long shopId, @PathVariable long tableNum){

        boolean check = deskService.deleteDesk(shopId, tableNum);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{shopId}/{tableNum}")
    public ResponseEntity<?> PutDesk(@PathVariable long shopId, @PathVariable long tableNum , @RequestBody PutTableDto putTableDto){

        boolean check = deskService.putDesk(shopId, tableNum, putTableDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
