package xxx.petmanbe.visited.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xxx.petmanbe.visited.entity.Visited;

public interface VisitedRepository extends JpaRepository<Visited,Long> {

    @Query("select i from Visited i where i.user.userId = :User and i.shop.shopId = :Shop")
    Optional<Visited> findByUserShopJpql(@Param("User") long userId, @Param("Shop") long shopId);

}
