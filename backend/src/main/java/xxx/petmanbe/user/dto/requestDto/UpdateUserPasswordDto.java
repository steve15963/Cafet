package xxx.petmanbe.user.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserPasswordDto {
	private String email;
	private String password;
}
