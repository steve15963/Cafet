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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.Location.entity.BeaconLocation;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shopFile.entity.ShopFile;
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

	@Column(name = "like_cnt",columnDefinition = "integer default 0")
	private int likeCnt;

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

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "shop")
	private List<ShopFile> shopFileList;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public void updateShop(PutShopDto request) {
		this.shopTitle = request.getShopTitle();
		this.address = request.getAddress();
		this.phoneNo = request.getPhoneNo();
		this.descriptions = request.getDescriptions();
		this.openedTime = request.getOpenedTime();
		this.closedTime = request.getClosedTime();
		this.sns = request.getSns();
		this.homepage = request.getHomepage();
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private List<BeaconLocation> BeaconLocation;

	public void updateShop(String shopTitle, long totalScore, int gradeCount,  double longitude,
		double latitude, String address, String phoneNo, String descriptions, String openedTime,
		String closedTime, String sns, String homepage){
		this.shopTitle=shopTitle;
		this.totalScore=totalScore;
		this.gradeCount=gradeCount;
		this.longitude=longitude;
		this.latitude=latitude;
		this.address=address;
		this.phoneNo=phoneNo;
		this.descriptions=descriptions;
		this.openedTime=openedTime;
		this.closedTime=closedTime;
		this.sns=sns;
		this.homepage=homepage;
	}

	public void updateGrade(long totalScore, int gradeCount){
		this.totalScore=totalScore;
		this.gradeCount=gradeCount;
	}

	public void plusLikeCnt(){
		this.likeCnt++;
	}

	public void minusLikeCnt(){
		this.likeCnt--;
	}

	public void changeDeleteStatus(){
		this.status = !this.status;
	}


}
