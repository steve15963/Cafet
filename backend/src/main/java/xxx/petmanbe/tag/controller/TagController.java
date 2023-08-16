package xxx.petmanbe.tag.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.service.TagService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tag")
public class TagController {
	private final TagService tagService;

	// 태그 정보 가져오기
	@GetMapping("/{tagName}")
	public ResponseEntity<Tag> getTag(@PathVariable String tagName){
		
		// 태그 가져오기
		Tag tag = tagService.getTag(tagName);

		// 결과 반환
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	// 태그 보기
	@GetMapping("")
	public ResponseEntity<List<TagListResponseDto>> getTagList(){

		List<TagListResponseDto> tagList = tagService.getTagList().stream()
			.map(TagListResponseDto::new)
			.collect(Collectors.toList());

		return new ResponseEntity<>(tagList, HttpStatus.OK);
	}
}
