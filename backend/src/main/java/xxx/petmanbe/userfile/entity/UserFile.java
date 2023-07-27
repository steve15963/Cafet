package xxx.petmanbe.userfile.entity;

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
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFile {


	@Id
	@Column(name="userfile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userfileId;

	@Column
	private String userUrl;

}
