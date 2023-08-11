package xxx.petmanbe.shopPet.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shopPet.dto.request.PutShopPetDto;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopPet extends BaseTimeEntity {

	@Id
	@Column(name="shop_pet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopPetId;

	@Column
	private String petName;

	@Column
	private int petAge;

	@Column
	private String gender;

	@Column
	private String species;

	@Column
	private String description;

	@Column
	private String birth;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@OneToMany(fetch = FetchType.LAZY)
	private List<PetLocation> petLocationList;

	public void updateShopPet(PutShopPetDto request){
		this.petName = request.getPetName();
		this.petAge = request.getPetAge();
		this.gender = request.getGender();
		this.species = request.getSpecies();
		this.description = request.getDescription();
		this.birth = request.getBirth();
	}


	//soft-delete
	public void changeDeleteStatus(){
		this.status = !this.status;
	}

}
