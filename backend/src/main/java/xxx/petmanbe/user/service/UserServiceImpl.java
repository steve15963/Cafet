package xxx.petmanbe.user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.LevelRepository;
import xxx.petmanbe.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private LevelRepository levelRepository;

	@Override
	public String postnewUser(RegistDto registDto) throws Exception {

		User user = User.builder()
			.email(registDto.getEmail())
			.password(registDto.getPassword())
			.phoneNo(registDto.getPhoneNo())
			.nickname(registDto.getNickname())
			.status("no")
			.createdDate(LocalDateTime.now())
			.updatedDate(LocalDateTime.now())
			.build();

		Level level = Level.builder().level_code(100).build();

		user.setLevel(level);

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
	public String putUser(UserModifyDto userModifyDto) throws Exception {

		User user = userRepository.findByEmail(userModifyDto.getEmail());

		user.setPhoneNo(userModifyDto.phoneNo);
		user.setNickname(userModifyDto.nickname);

		userRepository.save(user);

		if(user.getNickname()== userModifyDto.nickname && user.getPhoneNo()== userModifyDto.phoneNo){
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

	@Override
	public String deleteUser(long userId) {

		User user = userRepository.findByUserId(userId);

		user.setStatus("yes");

		userRepository.save(user);

		if(user.getStatus()=="yes"){
			return "success";
		}else{
			return "fail";
		}
	}

	@Override
	public String putUserLevel(LevelModifyDto levelModifyDto) {

		User user = userRepository.findByUserId(levelModifyDto.getUserId());

		Level level = user.getLevel();

		level.setLevel_code(levelModifyDto.getLevel());

		levelRepository.save(level);

		if(user.getLevel().getLevel_code()== level.getLevel_code()){
			return "success";

		}else{
			return "fail";
		}
	}

}
