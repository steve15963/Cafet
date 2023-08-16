package xxx.petmanbe.Location.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.Location.dto.requestDto.AddPetLocationRequestDto;
import xxx.petmanbe.Location.dto.requestDto.HitMapRequestDto;
import xxx.petmanbe.Location.dto.responseDto.HitMapResponseDto;
import xxx.petmanbe.Location.dto.responseDto.PetLocationResponseDto;
import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.Location.service.HitMapService;
import xxx.petmanbe.Location.service.LocationService;
import xxx.petmanbe.Location.service.LocationServiceImpl;

@Slf4j
@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
@CrossOrigin("*")
public class LocationController {

	private final LocationService locationService;

	private final HitMapService hitMapService;

	@PostMapping("/pet")
	public ResponseEntity<PetLocationResponseDto> SavePetLocation(@RequestBody AddPetLocationRequestDto addPetLocationRequestDto){
		log.info(addPetLocationRequestDto.toString());
		PetLocation petLocation = locationService.getTrilateration(addPetLocationRequestDto);
		log.info("Location Test : {}", petLocation);
		return new ResponseEntity<>(
			new PetLocationResponseDto(petLocation),
			petLocation == null ?HttpStatus.BAD_REQUEST: HttpStatus.ACCEPTED
		);
	}

	@GetMapping("/pet")
	public ResponseEntity<HitMapResponseDto> GetHitMap(@RequestParam long animalId){
		HitMapResponseDto hitMap = hitMapService.getHitMap(animalId);
		return new ResponseEntity<>(hitMap,HttpStatus.OK);
	}
}
