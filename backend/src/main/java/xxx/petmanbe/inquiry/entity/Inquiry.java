package xxx.petmanbe.inquiry.entity;

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
import xxx.petmanbe.common.entity.BaseTimeEntity;

@Entity
@Table(name = "inquiry")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inquiry_id", updatable = false)
	private Long inquiryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inquiry_category_id", nullable = false)
	private InquiryCategory inquiryCategory;

	@Column(name = "inquiry_title", nullable = false)
	private String inquiryTitle;

	@Column(name = "inquiry_content", nullable = false)
	private String inquiryContent;

	@Column(name = "nickname", nullable = false)
	private String nickname;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phoneNo", nullable = false)
	private String phoneNo;
}
