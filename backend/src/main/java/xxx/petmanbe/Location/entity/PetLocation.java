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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shopPet.entity.ShopPet;

@Entity
@Table(name = "PetLocationTimeLine")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetLocation extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "pet_location_time_line_id", nullable = false, updatable = false)
	private long pet_location_store_time_id;

	@ManyToOne
	@JoinColumn(name = "shop_pet_id")
	private ShopPet shopPet;

	@Column(name = "x")
	private double x;
	@Column(name = "y")
	private double y;
	@Column(name = "z")
	private double z;

	@Column(name = "temp")
	private double tmep;

	@OneToMany(fetch = FetchType.LAZY)
	List<useBeaconForPetLocation> useBeaconForPetLocationList;


}
