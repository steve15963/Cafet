package xxx.petmanbe.shopPetFile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shopPet.entity.ShopPet;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopPetFile {

	@Id
	@Column(name="shoppetfile_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopPetFileId;

	@Column
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="shop_pet_id")
	private ShopPet shopPet;



}
