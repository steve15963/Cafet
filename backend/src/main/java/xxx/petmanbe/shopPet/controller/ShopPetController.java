package xxx.petmanbe.shopPet.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import xxx.petmanbe.shop.service.ShopService;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.request.PutShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.service.ShopPetService;
import xxx.petmanbe.shopPetFile.service.ShopPetFileService;

@RestController
@RequestMapping(value="/api/shopPet")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ShopPetController {

    private final ShopPetService shopPetService;

    private final ShopPetFileService shopPetFileService;


    @GetMapping("{shopId}")
    public ResponseEntity<GetShopPetDto> GetShopPet(@PathVariable long shopId){

        GetShopPetDto getShopPetDto = shopPetService.getShopPet(shopId);

        return new ResponseEntity<>(getShopPetDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> PostShopPet(@RequestPart(value="dto") PostShopPetDto request,@RequestPart(value="files", required = false) List<MultipartFile> files) throws
        IOException {

        long shopPetId = shopPetService.postShopPet(request);

            if(!Objects.isNull(files)){
                if(shopPetFileService.keepFile(files, shopPetId)){

                    return new ResponseEntity<>("pictures in", HttpStatus.OK);
                }
            }

            return new ResponseEntity<>("no pics", HttpStatus.BAD_REQUEST);



    }

    //soft-delete
    @DeleteMapping("{shopPetId}")
    public ResponseEntity<?> DeleteShopPet(@PathVariable Long shopPetId ){

        shopPetService.deleteShopPet(shopPetId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("")
    public ResponseEntity<?> PutShopPet(@RequestBody PutShopPetDto putShopPetDto){

        shopPetService.putShopPet(putShopPetDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
