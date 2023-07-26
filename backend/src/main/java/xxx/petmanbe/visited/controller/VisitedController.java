package xxx.petmanbe.visited.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.visited.dto.reponseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.reponseDto.GetVisitedDateDto;
import xxx.petmanbe.visited.dto.reponseDto.PostVisitedDateDto;
import xxx.petmanbe.visited.service.VisitedService;

@RestController
@RequestMapping(value="/api/visited")
@RequiredArgsConstructor
public class VisitedController {

	private final VisitedService visitedService;

	@GetMapping("")
	public ResponseEntity<Boolean> GetVisitedDate(@RequestBody GetVisitedDateDto getVisitedDateDto){

		Boolean visit = visitedService.getVisitedDate(getVisitedDateDto);

		return new ResponseEntity<>(visit, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<String> PostVisitedDate(@RequestBody PostVisitedDateDto postVisitedDateDto){

		String msg = visitedService.postVisitedDate(postVisitedDateDto);

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<String> DeleteVisitedDate(@RequestBody DeleteVisitedDateDto deleteVisitedDateDto){

		String msg = visitedService.deleteVisitedDate(deleteVisitedDateDto);

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}


}
