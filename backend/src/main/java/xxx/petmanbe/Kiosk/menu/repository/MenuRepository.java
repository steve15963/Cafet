package xxx.petmanbe.Kiosk.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xxx.petmanbe.Kiosk.menu.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    Optional<List<Menu>> findAllByShop_shopId(long shopId);

}
