package xxx.petmanbe.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likeBoard")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_id", nullable = false, updatable = false)
	private Long likeId;

	private Long userId;

	private Long boardId;
}
