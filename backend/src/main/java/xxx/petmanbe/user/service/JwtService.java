package xxx.petmanbe.user.service;

import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;

public interface JwtService {

	String refreshToken(String refreshToken);
	Token saveToken(User user, String refreshToken, String accessToken);
}
