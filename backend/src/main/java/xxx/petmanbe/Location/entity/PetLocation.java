package xxx.petmanbe.Location.entity;

import java.time.LocalDateTime;
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
import lombok.ToString;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shopPet.entity.ShopPet;

@Entity
@Table
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetLocation extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	long petLocationId;

	@ManyToOne
	@JoinColumn(name = "shopPetId")
	ShopPet shopPet;

	@Column
	double x;

	@Column
	double y;

	@Column
	double z;

	@Column
	double temp;
}
