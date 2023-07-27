package xxx.petmanbe.tag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	// 태그 생성 시 이미 있는 태그인지 확인
	Optional<Tag> findByStatusFalseAndTagName(String tagName);
}
