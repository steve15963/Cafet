package xxx.petmanbe.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtService jwtService;


	@Override
	public String postnewUser(RegistDto registDto) throws Exception {

		User user = User.builder()
			.email(registDto.getEmail())
			.password(registDto.getPassword())
			.phoneNo(registDto.getPhoneNo())
			.nickname(registDto.getNickname())
			.level(100)
			.status("no")
			.createdDate(LocalDateTime.now())
			.updatedDate(LocalDateTime.now())
			.build();

		String email = userRepository.save(user).getEmail();

		return email;
	}

	@Override
	public Token postLoginUser(LoginDto loginDto) throws Exception {

		User user = userRepository.findByEmail(loginDto.getEmail());

		String accessToken = jwtUtil.generateAccessToken(user);

		String refreshToken = jwtUtil.generateRefreshToken(user);

		Token token = jwtService.saveToken(user, accessToken, refreshToken);

		return token;
	}



}
