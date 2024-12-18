package xxx.petmanbe.Location.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.Location.dto.requestDto.AddPetLocationRequestDto;
import xxx.petmanbe.Location.dto.responseDto.HitMapResponseDto;
import xxx.petmanbe.Location.dto.responseDto.PetLocationResponseDto;
import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.Location.service.HitMapService;
import xxx.petmanbe.Location.service.LocationService;

@Slf4j
@RestController
@RequestMapping("/api/location")
@Tag(name = "동물 위치정보", description = "동물 위치정보 관련 API Docs")
@AllArgsConstructor
@CrossOrigin("*")
public class LocationController {

	private final LocationService locationService;

	private final HitMapService hitMapService;

	private final SimpMessageSendingOperations template;


	/**
	 * 동물의 위치를 저장하는 컨트롤러 메소드
	 * @param addPetLocationRequestDto 비콘의 인덱스 값과 그 거리를 내포한 VO이다.
	 * @return 거리 계산 실패 유무에 따라서 Bad와 ACCEPTED를 반환한다.
	 */
	@PostMapping("/pet")
	@Operation(summary = "동물 위치 정보 저장하기")
	public ResponseEntity<PetLocationResponseDto> SavePetLocation(@RequestBody AddPetLocationRequestDto addPetLocationRequestDto){
		log.info(addPetLocationRequestDto.toString());
		PetLocation petLocation = locationService.getTrilateration(addPetLocationRequestDto);
		log.info("add Location Test : {}", addPetLocationRequestDto);

		PetLocationResponseDto p = new PetLocationResponseDto(petLocation);

		String a = String.valueOf(p.getX())+ '\n'+ String.valueOf(p.getY());

		template.convertAndSend("/topic/map/1", a);


		return new ResponseEntity<>(
			new PetLocationResponseDto(petLocation),
			petLocation == null ?HttpStatus.BAD_REQUEST: HttpStatus.ACCEPTED
		);
	}

	/**
	 * HitMap.js에 들어갈 Json을 프론트에게 내려주는 컨트롤러
	 * @param animalId 찾고자 하는 동물의 ID
	 * @return Hitmap.js에 들어가는 Json데이터.
	 */
	@GetMapping("/pet")
	@Operation(summary = "동물 위치 정보 전달하기")
	public ResponseEntity<HitMapResponseDto> GetHitMap(@RequestParam long animalId){
		HitMapResponseDto hitMap = hitMapService.getHitMap(animalId);
		return new ResponseEntity<>(hitMap,HttpStatus.OK);
	}
}
