package xxx.petmanbe.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xxx.petmanbe.user.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

	Level findByLevelId(String levelId);



}
