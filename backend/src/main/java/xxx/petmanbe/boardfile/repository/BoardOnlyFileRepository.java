package xxx.petmanbe.boardfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.boardfile.entity.BoardOnlyFile;

public interface BoardOnlyFileRepository extends JpaRepository<BoardOnlyFile, Long> {
}
