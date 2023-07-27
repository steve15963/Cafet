package xxx.petmanbe.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
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

	@Transactional
	@Override
	public long postnewUser(RegistDto registDto) throws Exception {

		User user = User.builder()
				.email(registDto.getEmail())
				.password(registDto.getPassword())
				.phoneNo(registDto.getPhoneNo())
				.nickname(registDto.getNickname())
				.status("no")
				.build();

		Level level = Level.builder().levelCode(100).build();

		System.out.println(level);

		user.setLevel(level);

		long userId = userRepository.save(user).getUserId();

		return userId;
	}

	@Transactional
	@Override
	public boolean checkUserLogin(LoginDto loginDto) throws Exception{

		User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new IllegalArgumentException());

		if(loginDto.getPassword()==user.getPassword()) return true;

		return false;

	// }

	// @Transactional
	// @Override
	// public Optional<RefreshJwtDto> postLoginUser(LoginDto loginDto) throws Exception {
	//
	// 	User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new IllegalArgumentException());
	//
	// 	if(!Objects.equals(loginDto.getPassword(), user.getPassword())) {
	// 		return null;
	// 	}
	//
	// 	String accessToken = jwtUtil.generateAccessToken(user);
	//
	// 	String refreshToken = jwtUtil.generateRefreshToken(user);
	//
	// 	// Token token = jwtService.saveToken(user, accessToken, refreshToken);
	//
	// 	// LoginRequestDto loginRequestDto = LoginRequestDto.builder()
	// 	// 	.userId(user.getUserId())
	// 	// 	.token(token)
	// 	// 	.build();
	//
	// 	return Optional.ofNullable(
	// 		new RefreshJwtDto(
	// 			new AccessJwtTokenDto(accessToken),
	// 			refreshToken
	// 		)
	// 	);
	}

	@Transactional
	@Override
	public String putUser(UserModifyDto userModifyDto) throws Exception {

		User user = userRepository.findByEmail(userModifyDto.getEmail()).orElseThrow(()->new IllegalArgumentException());

		System.out.println(user.getUserId());

		user.updateUser(userModifyDto.phoneNo,userModifyDto.nickname);

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

		User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());

		UserInformationDto userInformationDto = UserInformationDto.builder()
				.email(user.getEmail())
				.phoneNo(user.getPhoneNo())
				.nickname(user.getNickname())
				.status(user.getStatus())
				.level(user.getLevel())
				.createdTime(user.getCreatedTime())
				.updatedTime(user.getUpdatedTime())
				.build();

		return userInformationDto;
	}

	@Override
	public User SessionLogin(LoginDto loginDto) throws Exception {
		Optional<User> findUser = userRepository.findByEmail(loginDto.getEmail());

		System.out.println(findUser.get().getUserId());

		if(findUser.isEmpty()){
			return null;
		}
		else{
			User user = findUser.get();
			if(loginDto.getPassword().equals(user.getPassword())){
				return user;
			}
			return null;
		}
	}

	@Transactional
	@Override
	public List<UserListDto> getUserList() {

		List<UserListDto> userList = userRepository.findAllBy().orElseThrow(()-> new IllegalArgumentException());

		return userList;
	}

	@Transactional
	@Override
	public String deleteUser(long userId) {

		User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());

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

		User user = userRepository.findById(levelModifyDto.getUserId()).orElseThrow(()->new IllegalArgumentException());

		Level level = user.getLevel();

		level.setLevelCode(levelModifyDto.getLevel());

		levelRepository.save(level);

		if(user.getLevel().getLevelCode()== level.getLevelCode()){
			return "success";

		}else{
			return "fail";
		}
	}

}
