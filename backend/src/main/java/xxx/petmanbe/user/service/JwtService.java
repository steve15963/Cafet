package xxx.petmanbe.user.service;

import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;

public interface JwtService {

	public String refreshToken(String refreshToken);

	Token saveToken(User user, String refreshToken, String accessToken);

}
