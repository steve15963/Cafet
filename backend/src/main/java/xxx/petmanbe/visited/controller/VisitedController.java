package xxx.petmanbe.visited.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xxx.petmanbe.visited.dto.responseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.GetVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.PostVisitedDateDto;
import xxx.petmanbe.visited.entity.Visited;
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
    public ResponseEntity<String> PostVisitedDate(@RequestPart("dto") PostVisitedDateDto request){

        String msg = visitedService.postVisitedDate(request);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> DeleteVisitedDate(@RequestPart("dto") DeleteVisitedDateDto request){

        String msg = visitedService.deleteVisitedDate(request);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
