package xxx.petmanbe.tag.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.shop.entity.Shop;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attachShopId;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;
}
