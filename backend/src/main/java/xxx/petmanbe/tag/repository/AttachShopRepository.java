package xxx.petmanbe.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.AttachShop;

public interface AttachShopRepository extends JpaRepository<AttachShop, Long> {

	List<AttachShop> findByShop_ShopId(Long shopId);

	List<AttachShop> findByTag_TagName(String tagName);

	void deleteByShop_ShopIdAndTag_TagId(Long shopId, Long tagId);
}
