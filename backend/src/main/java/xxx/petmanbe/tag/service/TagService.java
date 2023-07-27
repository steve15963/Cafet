package xxx.petmanbe.tag.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.TagRepository;

@Service
@RequiredArgsConstructor
public class TagService {
	private final TagRepository tagRepository;

	// 태그 생성
	public Tag postTag(AddTagRequestDto request){
		return tagRepository.save(request.toEntity());
	}

	// 태그 목록 보기
	public List<Tag> getTagList(){
		return tagRepository.findAll();
	}
}
