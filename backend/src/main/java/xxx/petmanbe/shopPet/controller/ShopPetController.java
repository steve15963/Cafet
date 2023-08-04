package xxx.petmanbe.shopPet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.shop.service.ShopService;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.service.ShopPetService;

@RestController
@RequestMapping(value="/api/shopPet")
@RequiredArgsConstructor
public class ShopPetController {

    private final ShopPetService shopPetService;


    @GetMapping("{shopId}")
    public ResponseEntity<GetShopPetDto> GetShopPet(@PathVariable long shopId){

        GetShopPetDto getShopPetDto = shopPetService.getShopPet(shopId);

        return new ResponseEntity<>(getShopPetDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> PostShopPet(@RequestBody PostShopPetDto request){

        boolean check = shopPetService.postShopPet(request);

        if(check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("{shopPetId}")
    public ResponseEntity<?> DeleteShopPet(@PathVariable Long shopPetId ){

        boolean check = shopPetService.deleteShopPet(shopPetId);

        if(check){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
