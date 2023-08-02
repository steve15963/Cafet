package xxx.petmanbe.user.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.RefreshJwtDto;
import xxx.petmanbe.user.dto.responseDto.UserFilesListDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.LevelRepository;
import xxx.petmanbe.user.repository.UserRepository;
import xxx.petmanbe.userfile.entity.UserFile;
import xxx.petmanbe.userfile.repository.UserFileRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	private final JwtUtil jwtUtil;

	private final JwtService jwtService;

	private final LevelRepository levelRepository;

	private final UserFileRepository userFileRepository;

	private final CustomUserDetailService customUserDetailService;

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

	 }

	 @Transactional
	 @Override
	 public RefreshJwtDto postLoginUser(LoginDto loginDto) throws Exception {

	 	User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new IllegalArgumentException());

	 	if(!Objects.equals(loginDto.getPassword(), user.getPassword())) {
	 		return null;
	 	}

//		 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword());
//		 Authentication authentication = AuthenticationManagerBuilder.getObject().authenticate(authenticationToken);
		 //		 Token token = jwtUtil.generateAccessToken(authentication);

		 List<String> role = new LinkedList<>();
		 role.add("ADMIN");

	 	String accessToken = jwtUtil.generateAccessToken(user.getEmail(),role);

	 	String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

	 	 Token token = jwtService.saveToken(user, accessToken, refreshToken);

		  RefreshJwtDto refreshJwtDto = RefreshJwtDto.builder()
				  .refreshToken(refreshToken)
				  .accessToken(accessToken)
				  .build();

		  user.setToken(token);

		  userRepository.save(user);

		  System.out.println(refreshToken);

	 	return refreshJwtDto;
	}

	@Transactional
	@Override
	public boolean putUser(UserModifyDto userModifyDto) throws Exception {

		User user = userRepository.findByEmail(userModifyDto.getEmail()).orElseThrow(()->new IllegalArgumentException());

		user.updateUser(userModifyDto.phoneNo,userModifyDto.nickname);

		userRepository.save(user);

		if(user.getNickname()== userModifyDto.nickname && user.getPhoneNo()== userModifyDto.phoneNo){
			return true;

		}else{
			return false;
		}
	}

	@Transactional
	@Override
	public UserInformationDto getUser(long userId) throws Exception {

		User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());

		UserFilesListDto userFilesListDto = userFileRepository.findById(user.getUserFile().getUserfileId()).stream()
			.map(UserFilesListDto::new)
			.findFirst().orElseThrow(()->new IllegalArgumentException());


		UserInformationDto userInformationDto = UserInformationDto.builder()
				.email(user.getEmail())
				.phoneNo(user.getPhoneNo())
				.nickname(user.getNickname())
				.status(user.getStatus())
				.levelCode(user.getLevel().getLevelCode())
				.createdTime(user.getCreatedTime())
				.updatedTime(user.getUpdatedTime())
				.userFile(userFilesListDto)
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
