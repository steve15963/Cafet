package xxx.petmanbe.tag.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.TagRepository;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;

	// 태그 생성
	@Override
	public Tag postTag(AddTagRequestDto request){
		return tagRepository.save(request.toEntity());
	}

	// 태그 목록 보기
	@Override
	public List<Tag> getTagList(){
		return tagRepository.findAll();
	}
}
