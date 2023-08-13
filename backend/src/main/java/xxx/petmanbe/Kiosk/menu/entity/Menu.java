package xxx.petmanbe.Kiosk.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import xxx.petmanbe.Kiosk.menufile.entity.MenuFile;
import xxx.petmanbe.shop.entity.Shop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id", nullable = false, updatable = false)
	private Long menuId;

	//대분류
	
	// 주문량
	@Column
	private String menuType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	private List<MenuPriceSize> menuPriceSize;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="menuFile_id")
	private MenuFile menuFile;
	
	//shop이랑 연결
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;


}
