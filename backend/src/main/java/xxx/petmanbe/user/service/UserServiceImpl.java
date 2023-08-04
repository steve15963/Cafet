package xxx.petmanbe.user.service;

import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserFilesListDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.LevelRepository;
import xxx.petmanbe.user.repository.UserRepository;
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

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public long postnewUser(RegistDto registDto) throws Exception {

		List<String> roles= new ArrayList<>();

		roles.add("USER");

		User user = User.builder()
				.email(registDto.getEmail())
				.password(passwordEncoder.encode(registDto.getPassword()))
				.phoneNo(registDto.getPhoneNo())
				.nickname(registDto.getNickname())
				.status("no")
				.roles(roles)
				.build();

		Level level = Level.builder().levelCode(100).build();


		user.setLevel(level);

		return userRepository.save(user).getUserId();
	}

	@Transactional
	@Override
	public boolean checkUserLogin(LoginDto loginDto) throws Exception{

		User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(IllegalArgumentException::new);

		if(Objects.equals(loginDto.getPassword(), user.getPassword())) return true;

		return false;

	 }

	 @Transactional
	 @Override
	 public Token postLoginUser(LoginDto loginDto) throws Exception {

	 	User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(IllegalArgumentException::new);

		 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

		 Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		 Token token = jwtUtil.generateToken(authentication);

		  user.setToken(token);

		  userRepository.save(user);

	 	return token;
	}

	@Transactional
	@Override
	public boolean putUser(UserModifyDto userModifyDto) throws Exception {

		User user = userRepository.findByEmail(userModifyDto.getEmail()).orElseThrow(IllegalArgumentException::new);

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

		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

		UserFilesListDto userFilesListDto = userFileRepository.findById(user.getUserFile().getUserfileId()).stream()
			.map(UserFilesListDto::new)
			.findFirst().orElseThrow(IllegalArgumentException::new);

		List<String> role = user.getRoles();

		return UserInformationDto.builder()
				.email(user.getEmail())
				.phoneNo(user.getPhoneNo())
				.nickname(user.getNickname())
				.status(user.getStatus())
				.levelCode(user.getLevel().getLevelCode())
				.createdTime(user.getCreatedTime())
				.updatedTime(user.getUpdatedTime())
				.userFile(userFilesListDto)
				.role(role)
				.build();
	}

	// 없앨 예정
//	@Override
//	public User SessionLogin(LoginDto loginDto) throws Exception {
//		Optional<User> findUser = userRepository.findByEmail(loginDto.getEmail());
//
//		System.out.println(findUser.get().getUserId());
//
//		if(findUser.isEmpty()){
//			return null;
//		}
//		else{
//			User user = findUser.get();
//			if(loginDto.getPassword().equals(user.getPassword())){
//				return user;
//			}
//			return null;
//		}
//	}

	@Transactional
	@Override
	public List<UserListDto> getUserList() {

		return userRepository.findAll().stream()
			.map(UserListDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public String deleteUser(long userId) {

		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

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

		User user = userRepository.findById(levelModifyDto.getUserId()).orElseThrow(IllegalArgumentException::new);

		Level level = user.getLevel();

		level.setLevelCode(levelModifyDto.getLevel());

		// role
		if(200<= levelModifyDto.getLevel() && levelModifyDto.getLevel() <300 ){
			user.getRoles().set(0, "Shop");
		}else if(300<= levelModifyDto.getLevel()){
			user.getRoles().set(0,"ADMIN");
		}

		userRepository.save(user);

		if(user.getLevel().getLevelCode()== level.getLevelCode()){
			return "success";

		}else{
			return "fail";
		}


	}

	@Override
	public List<UserListDto> getUserListByEmail(String email) {
		return userRepository.findUsersByEmailContaining(email).stream()
			.map(UserListDto::new)
			.collect(Collectors.toList());
	}

	@Override
	public List<UserListDto> getUserListByNickname(String nickname) {
		return userRepository.findUsersByNicknameContaining(nickname).stream()
			.map(UserListDto::new)
			.collect(Collectors.toList());
	}

}
