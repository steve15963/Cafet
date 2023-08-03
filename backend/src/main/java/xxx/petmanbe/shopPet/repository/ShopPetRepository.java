package xxx.petmanbe.shopPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xxx.petmanbe.shopPet.entity.ShopPet;

import java.util.Optional;

public interface ShopPetRepository extends JpaRepository<ShopPet,Long> {

    Optional<ShopPet> findByShop_ShopId(long shopId);

}
