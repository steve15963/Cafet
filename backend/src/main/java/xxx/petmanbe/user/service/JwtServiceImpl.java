package xxx.petmanbe.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
public class JwtServiceImpl implements JwtService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public Token saveToken(User user, String refreshToken, String accessToken) {

		Token token = Token.builder()
			.user(user)
			.refreshToken(refreshToken)
			.accessToken(accessToken)
			.tokenType("Bearer")
			.build();

		user.setToken(token);

		userRepository.save(user);

		return token;
	}
}
