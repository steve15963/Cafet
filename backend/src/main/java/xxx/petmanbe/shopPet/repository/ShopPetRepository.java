package xxx.petmanbe.shopPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xxx.petmanbe.shopPet.entity.ShopPet;

import java.util.List;
import java.util.Optional;

public interface ShopPetRepository extends JpaRepository<ShopPet,Long> {

    List<ShopPet> findByShop_ShopId(long shopId);

}
