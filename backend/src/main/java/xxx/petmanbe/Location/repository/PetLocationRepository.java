package xxx.petmanbe.Location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.Location.entity.PetLocation;

public interface PetLocationRepository extends JpaRepository<PetLocation,Long> {
}
