package xxx.petmanbe.tag.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.Attach;

public interface AttachRepository extends JpaRepository<Attach, Long> {

	List<Attach> findByTag_TagName(String tagName);

	List<Attach> findByBoard_BoardId(Long boardId);

	void deleteByBoard_BoardIdAndTag_TagId(Long boardId, Long tagId);
}
