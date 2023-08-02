package xxx.petmanbe.board.entity;

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
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.comment.entity.Comment;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.user.entity.User;

@Entity
@Table(name = "board")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "board_id", nullable = false, updatable = false)
	private Long boardId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "board_title", length = 50, nullable = false)
	private String boardTitle;

	@Column(name = "board_content", nullable = false)
	private String boardContent;

	@Column(name = "like_sum", nullable = false, columnDefinition = "integer default 0")
	private int likeSum;

	@Column(name = "comment_sum", nullable = false, columnDefinition = "integer default 0")
	private int commentSum;

	@Column(name = "view_cnt", nullable = false, columnDefinition = "integer default 0")
	private int viewCnt;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
	private List<Comment> commentList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
	private List<BoardFile> boardFileList;

	// 게시글 수정을 위한 메소드
	public void updateBoard(Long boardId, UpdateBoardRequestDto request){
		this.boardTitle = request.getBoardTitle();
		this.boardContent = request.getBoardContent();
	}

	// 게시글 조회수 증가 메소드
	public void updateViewCnt(){
		this.viewCnt += 1;
	}

	// 게시글 좋아요 수 증가 메소드
	public void plusLikeSum() {
		this.likeSum += 1;
	}

	// 게시글 좋아요 수 감소 메소드
	public void minusLikeSum(){
		this.likeSum -= 1;
	}

	// 게시글 댓글 수 증가 메소드
	public void plusCommentSum() {
		this.commentSum += 1;
	}

	// 게시글 댓글 수 감소 메소드
	public void minusCommentSum(){
		this.commentSum -= 1;
	}

	// 카테고리 변경 메소드
	public void updateCategory(Category category) {
		this.category = category;
	}

	// 게시글 삭제 및 복구를 위한 메소드, true/false 전환
	public void changeDeleteStatus(){
		this.status = !this.status;
	}
}
