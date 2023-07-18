package xxx.petmanbe.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.LoginRequestDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.LevelRepository;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	private final JwtUtil jwtUtil;

	private final JwtService jwtService;

	private final LevelRepository levelRepository;


	// @Autowired
	// private UserRepository userRepository;
	//
	// @Autowired
	// private JwtUtil jwtUtil;
	//
	// @Autowired
	// private JwtService jwtService;
	//
	// @Autowired
	// private LevelRepository levelRepository;

	@Transactional
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

	@Transactional
	@Override
	public boolean checkUserLogin(LoginDto loginDto) throws Exception{

		User user = userRepository.findByEmail(loginDto.getEmail());

		if(loginDto.getPassword()==user.getPassword()) return true;

		return false;

	}

	@Transactional
	@Override
	public boolean postLoginUser(LoginDto loginDto) throws Exception {

		User user = userRepository.findByEmail(loginDto.getEmail());

		if(!Objects.equals(loginDto.getPassword(), user.getPassword())) {
			return false;
		}

		String accessToken = jwtUtil.generateAccessToken(user);

		String refreshToken = jwtUtil.generateRefreshToken(user);

		Token token = jwtService.saveToken(user, accessToken, refreshToken);

		// LoginRequestDto loginRequestDto = LoginRequestDto.builder()
		// 	.userId(user.getUserId())
		// 	.token(token)
		// 	.build();

		return true;
	}

	@Transactional
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

	@Transactional
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

	@Transactional
	@Override
	public List<UserListDto> getUserList() {

		List<UserListDto> userList = userRepository.findAllBy();

		return userList;
	}

	@Transactional
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

	@Transactional
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
