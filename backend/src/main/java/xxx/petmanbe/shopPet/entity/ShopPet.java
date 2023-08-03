package xxx.petmanbe.shopPet.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.units.qual.C;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.entity.Grade;
import xxx.petmanbe.shop.entity.Shop;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopPet extends BaseTimeEntity {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;


}
