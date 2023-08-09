package xxx.petmanbe.Location.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class useBeaconForPetLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "use_beacon_id", nullable = false, updatable = false)
	private long useBeaconId;

	@ManyToOne
	@JoinColumn(name = "beacon_id")
	private BeaconLocation beaconLocation;

	@ManyToOne
	@JoinColumn(name = "pet_location_store_time_id")
	private PetLocation petLocationTimeLine;

}
