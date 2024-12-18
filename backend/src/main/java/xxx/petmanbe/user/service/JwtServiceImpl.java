package xxx.petmanbe.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.TokenRepository;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService{

	private final UserRepository userRepository;

	private final JwtUtil jwtUtil;

	private final TokenRepository tokenRepository;

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

			Token token = tokenRepository.findByRefreshToken(refreshToken)
				.orElseThrow(()-> new RestApiException(CommonErrorCode.BAD_REQUEST));

			User user = token.getUser();

			 String newAccessToken = jwtUtil.generateAccessToken(user.getEmail(), user.getRoles());

			 token.setAccessToken(newAccessToken);
			 tokenRepository.save(token);
			 return newAccessToken;
		}
		return null;
	}
}
