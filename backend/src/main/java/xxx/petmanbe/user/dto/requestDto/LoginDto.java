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
public class LoginDto {

	@NotNull
	@Size(min=2, max = 64)
	private String email;

	@NotNull
	@Size(min=3, max = 25)
	private String password;

}
