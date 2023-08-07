package xxx.petmanbe.Location.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shop.entity.Shop;

@Entity
@Table(name = "BeaconLocation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BeaconLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "beacon_id", nullable = false, updatable = false)
	private Long beaconId;

	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;

	@Column
	double x;
	@Column
	double y;
	@Column
	double z;

	@OneToMany(fetch = FetchType.LAZY)
	List<useBeaconForPetLocation> useBeaconForPetLocationList;

}
