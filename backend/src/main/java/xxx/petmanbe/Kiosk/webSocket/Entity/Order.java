package xxx.petmanbe.Kiosk.webSocket.Entity;// package xxx.petmanbe.Kiosk.webSocket.Entity;
//
// import java.util.List;
//
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
// import javax.persistence.Table;
//
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import xxx.petmanbe.user.entity.User;
//
// @Entity
// @Table
// @Getter
// @Setter
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
// //주문
// public class Order {
//
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	@Column(name = "order_id", nullable = false, updatable = false)
// 	private Long orderId;
//
// 	// 주문량
// 	@Column
// 	private int orderCnt;
//
// 	// @OneToOne
// 	// private User user;
//
// 	// @OneToMany
// 	// List<Menu> menuList;
//
// }
