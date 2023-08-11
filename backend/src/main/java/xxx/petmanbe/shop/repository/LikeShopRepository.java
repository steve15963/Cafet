package xxx.petmanbe.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.shop.entity.LikeShop;

public interface LikeShopRepository extends JpaRepository<LikeShop, Long> {

	Optional<LikeShop> findByUser_UserIdAndShop_ShopId(Long userId, Long shopId);

	List<LikeShop> findByUser_UserId(Long userId);

	void deleteByUser_UserIdAndShop_ShopId(Long userId, Long shopId);
}
