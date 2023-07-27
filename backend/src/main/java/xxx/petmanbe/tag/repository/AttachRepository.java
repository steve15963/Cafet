package xxx.petmanbe.tag.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.Attach;

public interface AttachRepository extends JpaRepository<Attach, Long> {

	List<Attach> findByStatusFalseAndTag_TagName(String tagName);

	List<Attach> findByStatusFalseAndBoard_BoardId(Long boardId);

	// 태그 수정을 위해 단일 조회 쿼리
	Optional<Attach> findByBoard_BoardIdAndTag_TagId(Long boardId, Long tagId);
}
