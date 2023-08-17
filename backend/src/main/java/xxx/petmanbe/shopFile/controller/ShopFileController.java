package xxx.petmanbe.shopFile.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "가게 첨부파일", description = "가게 첨부파일 관련 API Docs")
@CrossOrigin("*")
public class ShopFileController {

    private final ShopFileService shopFileService;

    @PostMapping("")
    @Operation(summary = "파일 업로드")
    public ResponseEntity<?> PostShopFile(@RequestPart PostShopFileDto postShopFileDto, @RequestPart("files")List<MultipartFile> files) throws IOException {

        if(shopFileService.keepFile(files, postShopFileDto.getShopId())){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("{shopId}")
    @Operation(summary = "해당하는 가게의 첨부파일 목록 가져오기")
    public ResponseEntity<?> GetShopFile(@PathVariable long shopId){

        List<ShopFile> shopFileList = shopFileService.getShopFile(shopId);

        if(Objects.isNull(shopFileList)){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shopFileList, HttpStatus.OK);

    }




}
