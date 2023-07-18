package xxx.petmanbe.user.service;

import org.springframework.stereotype.Service;

import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.TokenRepository;
import xxx.petmanbe.user.repository.UserRepository;

@Service
public class JwtServiceImpl implements JwtService{

	private final UserRepository userRepository;

	private final JwtUtil jwtUtil;

	private final TokenRepository tokenRepository;

	public JwtServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, TokenRepository tokenRepository) {
		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
		this.tokenRepository = tokenRepository;
	}

	// public JwtServiceImpl(userRepository userRepository)
	//
	// @Autowired
	// private UserRepository userRepository;
	//
	// @Autowired
	// private JwtUtil jwtUtil;
	//
	// @Autowired
	// private TokenRepository tokenRepository;

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

	@Override
	public String refreshToken(String refreshToken) {

		if(jwtUtil.validateToken(refreshToken)){
			Token token = tokenRepository.findByRefreshToken(refreshToken);

			String newAccessToken = jwtUtil.getAccessToken(
				token.getUser().getUserId()
			);

			token.setAccessToken(newAccessToken);
			tokenRepository.save(token);
			return newAccessToken;
		}
		return null;
	}
}
