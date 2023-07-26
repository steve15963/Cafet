package xxx.petmanbe.user.dto.requestDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistDto {

	@NotNull
	@Size(min=2, max = 64)
	private String email;

	@NotNull
	@Size(min=3, max = 25)
	private String password;

	@NotNull
	@Size(min=11, max = 15)
	private String phoneNo;

	@NotNull
	@Size(min=3, max = 10)
	private String nickname;

}
