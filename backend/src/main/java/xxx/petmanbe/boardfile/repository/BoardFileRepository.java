package xxx.petmanbe.boardfile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.boardfile.entity.BoardFile;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {

	List<BoardFile> findAllByBoard_BoardId(long boardId);

}
