package xxx.petmanbe.shop.entity;

import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.*;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.user.entity.User;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop extends BaseTimeEntity {

	@Id
	@Column(name="shop_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopId;

	@Column
	private String shopTitle;

	@Column
	private long totalScore;

	@Column
	private int gradeCount;

	@Column
	private String sidoName;

	@Column
	private String gugunName;

	@Column
	private double longitude;

	@Column
	private double latitude;

	@Column
	private String address;

	@Column
	private String phoneNo;

	@Column(columnDefinition = "TEXT")
	private String descriptions;

	@Column
	private String openedTime;

	@Column
	private String closedTime;

	@Column
	private String sns;

	@Column(columnDefinition = "TEXT")
	private String homepage;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean status;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "shop")
	private List<Grade> shopGradeList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	private List<Board> boardList;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "shop")
	private List<ShopPet> shopPetList;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public void updateShop(PutShopDto request){
		this.shopTitle = request.getShopTitle();
		this.totalScore = request.getTotalScore();
		this.gradeCount = request.getGradeCount();
		this.longitude = request.getLongitude();
		this.latitude = request.getLatitude();
		this.address = request.getAddress();
		this.phoneNo=request.getPhoneNo();
		this.descriptions=request.getDescriptions();
		this.openedTime=request.getOpenedTime();
		this.closedTime=request.getClosedTime();
		this.sns=request.getSns();
		this.homepage=request.getHomepage();
	}

	public void updateGrade(long totalScore, int gradeCount){
		this.totalScore=totalScore;
		this.gradeCount=gradeCount;
	}

	public void changeDeleteStatus(){
		this.status = !this.status;
	}


}
