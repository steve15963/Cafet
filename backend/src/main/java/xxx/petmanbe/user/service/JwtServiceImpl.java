package xxx.petmanbe.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.TokenRepository;
import xxx.petmanbe.user.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

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

		System.out.println(refreshToken);

		if(jwtUtil.validateToken(refreshToken)){

			Token token = tokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new IllegalArgumentException());

			User user = token.getUser();

			 String newAccessToken = jwtUtil.generateAccessToken(user.getEmail(), user.getRoles());

			 token.setAccessToken(newAccessToken);
			 tokenRepository.save(token);
			 return newAccessToken;
		}
		return null;
	}
}
