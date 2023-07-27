package xxx.petmanbe.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xxx.petmanbe.shop.entity.Grade;
import xxx.petmanbe.visited.entity.Visited;

public interface GradeRepository extends JpaRepository<Grade,Long> {

	@Query("select i from Grade i where i.user.userId = :User and i.shop.shopId = :Shop")
	Optional<Grade> findByUserShopJpql(@Param("User") long userId, @Param("Shop") long shopId);


}
