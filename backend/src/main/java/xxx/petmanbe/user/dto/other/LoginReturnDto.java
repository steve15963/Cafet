package xxx.petmanbe.user.dto.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.user.dto.responseDto.LoginResponseDto;
import xxx.petmanbe.user.entity.Token;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginReturnDto {

	public LoginResponseDto loginResponseDto;

	public Token token;

}
