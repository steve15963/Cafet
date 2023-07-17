package xxx.petmanbe.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;


@NoArgsConstructor
@Getter
@Entity
@Setter
@Table
public class Token {
	@Id
	@Column(name="token_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenIndex;

	@Column
	private String tokenType;

	@Column
	private String accessToken;

	@Column
	private String refreshToken;

	@JsonIgnore
	@OneToOne(mappedBy = "token", cascade = CascadeType.ALL)
	private User user;

	@Builder
	public Token(String tokenType, String refreshToken, String accessToken, User user) {
		this.tokenType=tokenType;
		this.accessToken=accessToken;
		this.refreshToken= refreshToken;
		this.user = user;
	}
}
