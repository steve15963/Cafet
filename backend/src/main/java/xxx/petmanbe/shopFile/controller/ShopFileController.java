package xxx.petmanbe.shopFile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.shopFile.dto.PostShopFileDto;
import xxx.petmanbe.shopFile.dto.ShopFileDto;
import xxx.petmanbe.shopFile.entity.ShopFile;
import xxx.petmanbe.shopFile.service.ShopFileService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shopFile")
@CrossOrigin("*")
public class ShopFileController {

    private final ShopFileService shopFileService;

    @PostMapping("")
    public ResponseEntity<?> PostShopFile(@RequestPart PostShopFileDto postShopFileDto, @RequestPart("files")List<MultipartFile> files) throws IOException {

        if(shopFileService.keepFile(files, postShopFileDto.getShopId())){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("{shopId}")
    public ResponseEntity<?> GetShopFile(@PathVariable long shopId){

        List<ShopFile> shopFileList = shopFileService.getShopFile(shopId);

        if(Objects.isNull(shopFileList)){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shopFileList, HttpStatus.OK);

    }




}
