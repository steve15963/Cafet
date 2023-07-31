package xxx.petmanbe.tag.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.service.TagService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tag")
public class TagController {
	private final TagService tagService;

	// 태그 등록하기
	@PostMapping("/new")
	public ResponseEntity<Integer> postTag(@RequestPart("dto") AddTagRequestDto request){
		
		// 태그 등록
		tagService.postTag(request);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 태그 보기
	@GetMapping("/list")
	public ResponseEntity<List<TagListResponseDto>> getTagList(){

		List<TagListResponseDto> tagList = tagService.getTagList().stream()
			.map(TagListResponseDto::new)
			.collect(Collectors.toList());

		return new ResponseEntity<>(tagList, HttpStatus.OK);
	}
}
