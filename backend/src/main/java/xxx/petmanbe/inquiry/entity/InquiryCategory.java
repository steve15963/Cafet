package xxx.petmanbe.inquiry.entity;

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
@Table(name = "inquiry_category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inquiry_category_id", updatable = false)
	private Long inquiryCategoryId;

	@Column(name = "inquiry_category_name", unique = true)
	private String inquiryCategoryName;
}
