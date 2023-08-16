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
@CrossOrigin("*")
public class VisitedController {

    private final VisitedService visitedService;

    @GetMapping("/{userId}/{shopId}")
    public ResponseEntity<Boolean> GetVisitedDate(@PathVariable long userId, @PathVariable long shopId){

        Boolean visit = visitedService.getVisitedDate(userId, shopId);

        return new ResponseEntity<>(visit, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> PostVisitedDate(@RequestBody PostVisitedDateDto request){

        String msg = visitedService.postVisitedDate(request);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> DeleteVisitedDate(@RequestBody DeleteVisitedDateDto request){

        String msg = visitedService.deleteVisitedDate(request);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
