package xxx.petmanbe.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	// 이름으로 찾기
	Optional<Category> findByCategoryName(String categoryName);
}
