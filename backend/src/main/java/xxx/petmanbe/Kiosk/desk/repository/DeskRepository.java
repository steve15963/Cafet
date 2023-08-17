package xxx.petmanbe.Kiosk.desk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xxx.petmanbe.Kiosk.desk.entity.Desk;

public interface DeskRepository extends JpaRepository<Desk, Long> {

    Desk findTopByShop_ShopId(Long shopId);

    Optional<List<Desk>> findAllByShop_ShopId(Long shopId);

    @Query("select i from Desk i where i.deskNum = :DeskNum and i.shop.shopId = :Shop")
    Optional<Desk> findByShopIdAndDeskNum(@Param("DeskNum") long deskNum, @Param("Shop") long shopId);

}
