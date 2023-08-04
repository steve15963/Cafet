package xxx.petmanbe.tag.service;

import java.util.List;

import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.entity.Tag;

public interface TagService {
	// 태그 생성
	Tag postTag(AddTagRequestDto request);

	// 태그 목록 보기
	List<Tag> getTagList();
}
