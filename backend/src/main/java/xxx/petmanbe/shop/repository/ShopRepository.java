package xxx.petmanbe.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.user.entity.User;

public interface ShopRepository extends JpaRepository<Shop, Long> {

	Optional<Shop> findByStatusFalseAndShopTitle(String shopTitle);

	List<Shop> findByStatusFalse();

	List<Shop> findByStatusFalseAndShopTitleContaining(String shopTitle);

	List<Shop> findByStatusFalseAndAddressContaining(String address);

	List<Shop> findByStatusFalseAndAddressContainingOrShopTitleContaining(String address, String shopTitle);

	Optional<Shop> findByStatusFalseAndUser(User user);


}
