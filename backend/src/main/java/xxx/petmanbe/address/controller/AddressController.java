package xxx.petmanbe.address.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.address.repository.AddressRepository;

@RestController
@RequestMapping(value="/api/address")
@Tag(name = "주소", description = "주소 가져오기 API Docs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping("")
    @Operation(summary = "시/도 목록 가져오기")
    public ResponseEntity<?> getSido(){

        List<String> list = addressRepository.findDistinctSidoName();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{sidoName}")
    @Operation(summary = "해당 시/도의 구/군 목록 가져오기")
    public ResponseEntity<?> getGugun(@PathVariable String sidoName){

        List<String> list = addressRepository.findDistinctGugunName(sidoName);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


}
