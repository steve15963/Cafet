package xxx.petmanbe.tag.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.AttachBoard;

public interface AttachBoardRepository extends JpaRepository<AttachBoard, Long> {

	List<AttachBoard> findByTag_TagName(String tagName);

	List<AttachBoard> findByBoard_BoardId(Long boardId);

	void deleteByBoard_BoardIdAndTag_TagId(Long boardId, Long tagId);
}
