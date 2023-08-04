package xxx.petmanbe.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

	Optional<Shop> findByStatusFalseAndShopTitle(String shopTitle);

	// Optional<List<Shop>> findByDongCode(String dongCode);

	List<Shop> findByStatusFalse();

	List<Shop> findByStatusFalseAndShopTitleContaining(String shopTitle);

	List<Shop> findByStatusFalseAndAddressContaining(String address);
}
