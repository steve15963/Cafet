package xxx.petmanbe.Location.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.Location.dto.requestDto.AddPetLocationRequestDto;

@Slf4j
@RestController
public class LocationController {

	@PostMapping("/api/location/pet")
	public ResponseEntity<String> SavePetLocation(@RequestBody AddPetLocationRequestDto addPetLocationRequestDto){
		log.info(addPetLocationRequestDto.toString());
		return new ResponseEntity<>("", HttpStatus.ACCEPTED);
	}
}
