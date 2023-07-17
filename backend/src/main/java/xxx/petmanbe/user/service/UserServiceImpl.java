package xxx.petmanbe.user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.ModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
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

	@Override
	public String putUser(ModifyDto modifyDto) throws Exception {

		User user = userRepository.findByEmail(modifyDto.getEmail());

		user.setPhoneNo(modifyDto.phoneNo);
		user.setNickname(modifyDto.nickname);

		userRepository.save(user);

		if(user.getNickname()== modifyDto.nickname && user.getPhoneNo()== modifyDto.phoneNo){
			return "success";

		}else{
			return "fail";
		}
	}

	@Override
	public UserInformationDto getUser(long userId) throws Exception {


		User user = userRepository.findByUserId(userId);

		UserInformationDto userInformationDto = UserInformationDto.builder()
			.email(user.getEmail())
			.phoneNo(user.getPhoneNo())
			.nickname(user.getNickname())
			.status(user.getStatus())
			.level(user.getLevel())
			.createdDate(user.getCreatedDate())
			.updatedDate(user.getUpdatedDate())
			.build();

		return userInformationDto;
	}

	@Override
	public List<UserListDto> getUserList() {

		List<UserListDto> userList = userRepository.findAllBy();

		return userList;
	}

}
