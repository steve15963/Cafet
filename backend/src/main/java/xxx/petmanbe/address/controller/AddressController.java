package xxx.petmanbe.address.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.address.repository.AddressRepository;
import xxx.petmanbe.shop.entity.Shop;

import java.util.List;

@RestController
@RequestMapping(value="/api/address")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping("")
    public ResponseEntity<?> getSido(){

        List<String> list = addressRepository.findDistinctSidoName();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{sidoName}")
    public ResponseEntity<?> getGugun(@PathVariable String sidoName){

        List<String> list = addressRepository.findDistinctGugunName(sidoName);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


}