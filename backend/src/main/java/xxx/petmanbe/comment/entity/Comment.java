package xxx.petmanbe.comment.entity;

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
import xxx.petmanbe.board.entity.BaseTimeEntity;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.comment.dto.request.UpdateCommentRequestDto;

@Entity
@Table(name = "comment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id", nullable = false, updatable = false)
	private Long commentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	private Board board;

	// user 연결시 resolve
	// private String nickname;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean status;

	// update를 위한 메소드
	public void updateComment(UpdateCommentRequestDto request){
		this.content = request.getContent();
	}

	// 댓글 삭제/복구 메소드
	public void updateCommentStatus(){
		// 상태 전환
		this.status = !this.status;
	}
}
