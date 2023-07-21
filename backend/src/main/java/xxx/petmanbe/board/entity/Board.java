package xxx.petmanbe.board.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.comment.entity.Comment;

@Entity
@Table(name = "board")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "board_id", nullable = false, updatable = false)
	private Long boardId;

	private Long userId;

	private Long shopId;

	private Long categoryId;

	@Column(name = "board_title", length = 50, nullable = false)
	private String boardTitle;

	@Column(name = "board_content", nullable = false)
	private String boardContent;
	//
	// @Column(name = "created_time", nullable = false, columnDefinition = "timestamp default now()")
	// private LocalDateTime createdTime;
	//
	// @Column(name = "updated_time", nullable = false, columnDefinition = "timestamp default now()")
	// private LocalDateTime updatedTime;

	@Column(name = "like_sum", nullable = false, columnDefinition = "integer default 0")
	private int likeSum;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
	private List<Comment> commentList;

	// update를 위한 메소드
	public void updateBoard(Long boardId, UpdateBoardRequestDto request){
		this.boardTitle = request.getBoardTitle();
		this.boardContent = request.getBoardContent();
	}

	// 게시글 삭제 및 복구를 위한 메소드, true/false 전환
	public void changeDeleteStatus(){
		this.status = !this.status;
	}
}
