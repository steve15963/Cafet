package xxx.petmanbe.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table
public class Level {

	@Id
	@Column(name="level_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long levelId;

	@Column
	private int level_code;

	@Builder
	public Level(Long levelId, int level_code) {
		this.levelId = levelId;
		this.level_code = level_code;
	}
}
