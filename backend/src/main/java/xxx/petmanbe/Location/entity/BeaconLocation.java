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
import lombok.ToString;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.entity.Shop;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BeaconLocation extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long beaconId;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	Shop shop;

	@Column
	double x;
	@Column
	double y;
	@Column
	double z;

	@OneToMany
	// @JoinColumn(name = "useBeaconId")
	List<UseBeaconForPetLocation> useBeaconForPetLocationList;

}
