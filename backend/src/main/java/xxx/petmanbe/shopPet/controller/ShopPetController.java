package xxx.petmanbe.shopPet.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.shopPet.dto.request.PostShopPetDto;
import xxx.petmanbe.shopPet.dto.request.PutShopPetDto;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.service.ShopPetService;
import xxx.petmanbe.shopPetFile.service.ShopPetFileService;

@RestController
@RequestMapping(value="/api/shopPet")
@Tag(name = "동물", description = "가게별 동물 관리 API Docs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ShopPetController {

    private final ShopPetService shopPetService;

    private final ShopPetFileService shopPetFileService;


    @GetMapping("{shopId}")
    @Operation(summary = "해당 가게의 동물 목록 가져오기")
    public ResponseEntity<GetShopPetDto> GetShopPet(@PathVariable long shopId){

        GetShopPetDto getShopPetDto = shopPetService.getShopPet(shopId);

        return new ResponseEntity<>(getShopPetDto, HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "동물 등록하기")
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
    @Operation(summary = "가게 정보 삭제/복구하기")
    public ResponseEntity<?> DeleteShopPet(@PathVariable Long shopPetId){

        shopPetService.deleteShopPet(shopPetId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("")
    @Operation(summary = "가게 정보 수정하기")
    public ResponseEntity<?> PutShopPet(@RequestBody PutShopPetDto putShopPetDto){

        shopPetService.putShopPet(putShopPetDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
