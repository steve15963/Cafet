package xxx.petmanbe.Location.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.shopPet.entity.ShopPet;

public interface PetLocationRepository extends JpaRepository<PetLocation,Long> {
	public List<PetLocation> findTop1000PetLocationsByShopPetOrderByCreatedTimeDesc(ShopPet shopPet);
}
