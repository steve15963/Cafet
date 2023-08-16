package xxx.petmanbe.tag.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import xxx.petmanbe.common.entity.BaseTimeEntity;

@Entity
@Table(name = "tag")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id", nullable = false)
	private Long tagId;

	@Column(name = "tag_name", nullable = false, unique = true)
	private String tagName;

	@Column(name = "status", columnDefinition = "boolean default false")
	private boolean status;

	// 삭제여부 변수 수정
	public void changeDeleteStatus(){
		this.status = !this.status;
	}
}
