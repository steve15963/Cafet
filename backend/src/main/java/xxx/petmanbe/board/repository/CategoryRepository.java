package xxx.petmanbe.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.board.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
