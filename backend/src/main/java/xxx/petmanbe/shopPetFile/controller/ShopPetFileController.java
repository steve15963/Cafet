package xxx.petmanbe.shopPetFile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.shopPetFile.service.ShopPetFileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shopPetFile")
@CrossOrigin("*")
public class ShopPetFileController {

	private final ShopPetFileService shopPetFileService;

	// @PostMapping("")
	// public ResponseEntity<?> PostShopPetFile(@RequestBody ){
	//
	//
	//
	//
	//
	// }



}
