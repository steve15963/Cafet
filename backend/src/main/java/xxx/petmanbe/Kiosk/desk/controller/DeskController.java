package xxx.petmanbe.Kiosk.desk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostDeskDto;
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

    @PostMapping("")
    public ResponseEntity<?> PostDesk(@RequestBody PostDeskDto request){

        boolean check = deskService.postShop(request);

        if(!check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{shopId}/{tableNum}")
    public ResponseEntity<?> DeleteDesk(@PathVariable long shopId, @PathVariable long tableNum){

        boolean check = deskService.deleteDesk(shopId, tableNum);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
