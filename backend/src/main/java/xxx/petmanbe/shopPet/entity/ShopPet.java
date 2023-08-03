package xxx.petmanbe.shopPet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.checkerframework.checker.units.qual.C;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopPet {

	@Id
	@Column(name="shopPet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopPetId;

	@Column
	private String petName;

	@Column
	private String petAge;

	@Column
	private String gender;

	@Column
	private String species;

	@Column
	private String description;

	@Column
	private String birth;


}
