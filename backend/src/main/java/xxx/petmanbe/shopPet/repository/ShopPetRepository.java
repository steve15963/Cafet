package xxx.petmanbe.shopPet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.shopPet.entity.ShopPet;

public interface ShopPetRepository extends JpaRepository<ShopPet,Long> {

    List<ShopPet> findByShop_ShopId(long shopId);

}
