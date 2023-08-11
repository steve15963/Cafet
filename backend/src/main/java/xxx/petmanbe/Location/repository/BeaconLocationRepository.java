package xxx.petmanbe.Location.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.Location.entity.BeaconLocation;

public interface BeaconLocationRepository extends JpaRepository<BeaconLocation,Long> {
}
