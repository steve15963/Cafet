package xxx.petmanbe.tag.service;

import java.util.List;

import xxx.petmanbe.tag.entity.Tag;

public interface TagService {
	// 태그 하나 가져오기
	Tag getTag(String tagName);

	// 태그 목록 보기
	List<Tag> getTagList();
}
