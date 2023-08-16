package xxx.petmanbe.tag.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.TagRepository;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;

	// 태그 정보 가져오기
	@Override
	public Tag getTag(String tagName){
		// 있으면 결과 반환, 없으면 새로 생성
		return tagRepository.findByStatusFalseAndTagName(tagName).orElseGet(
			() -> Tag.builder()
				.tagName(tagName)
				.build()
		);
	}

	// 전체 태그 목록 보기
	@Override
	public List<Tag> getTagList(){
		return tagRepository.findAll();
	}
}
