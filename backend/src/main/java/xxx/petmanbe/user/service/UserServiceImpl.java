package xxx.petmanbe.user.service;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UpdateUserPasswordDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.LoginResponseDto;
import xxx.petmanbe.user.dto.responseDto.UserFilesListDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Level;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.LevelRepository;
import xxx.petmanbe.user.repository.TokenRepository;
import xxx.petmanbe.user.repository.UserRepository;
import xxx.petmanbe.userfile.repository.UserFileRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	private final TokenRepository tokenRepository;

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

		roles.add("ROLE_USER");

		Level level = levelRepository.findById((long)1).orElseThrow(()->new IllegalArgumentException());

		User user = User.builder()
				.email(registDto.getEmail())
				.password(passwordEncoder.encode(registDto.getPassword()))
				.phoneNo(registDto.getPhoneNo())
				.nickname(registDto.getNickname())
				.status("no")
				.level(level)
				.roles(roles)
				.build();

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
	public LoginReturnDto postLoginUser(LoginDto loginDto) throws Exception {

		User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(IllegalArgumentException::new);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		Token token = jwtUtil.generateToken(authentication);

		user.setToken(token);

		userRepository.save(user);

		LoginResponseDto loginResponseDto = LoginResponseDto.builder()
				.userId(user.getUserId())
				.level(user.getLevel().getLevelCode())
				.build();

		LoginReturnDto loginReturnDto = LoginReturnDto.builder()
				.loginResponseDto(loginResponseDto)
				.token(token)
				.build();


		return loginReturnDto;
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

		UserFilesListDto userFilesListDto=null;

		if(!Objects.isNull(user.getUserFile())){
			userFilesListDto = userFileRepository.findById(user.getUserFile().getUserfileId()).stream()
					.map(UserFilesListDto::new)
					.findFirst().orElse(new UserFilesListDto());
		}


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

		if(!Objects.equals(level, levelModifyDto.getLevel())){

			// role
			if(200<= levelModifyDto.getLevel() && levelModifyDto.getLevel() <300 ){
				level = levelRepository.findByLevelCode(levelModifyDto.getLevel()).orElseThrow(()->new IllegalArgumentException());
				user.setLevel(level);
				user.getRoles().set(0, "ROLE_SHOP");
			}else if(300<= levelModifyDto.getLevel()){
				level = levelRepository.findByLevelCode(levelModifyDto.getLevel()).orElseThrow(()-> new IllegalArgumentException());
				user.setLevel(level);
				user.getRoles().set(0,"ROLE_ADMIN");
			}

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

	@Transactional
	@Override
	public boolean changeUserPassword(UpdateUserPasswordDto request) {
		// user 정보로 가져오기
		Optional<User> user = userRepository.findByEmail(request.getEmail());

		// 정보가 있으면 변경하기
		if (user.isPresent()){
			user.get().updateUserPassword(passwordEncoder.encode(request.getPassword()));
			return true;
		}

		// 없으면 예외처리를 위해 false 반환
		return false;
	}

	@Override
	public boolean postLogout(HttpServletRequest request) {

		String[] token= request.getHeader("Cookie").split("; ");
		String refreshToken ="";

		for(int i=0 ; i<token.length ; i++) {
			if(token[i].substring(0,12).equals("refreshToken")){
				refreshToken=token[i].substring(13);
			}
		}

		Token token1 = tokenRepository.findByRefreshToken(refreshToken).orElseThrow(()-> new IllegalArgumentException());

		System.out.println(token1.getTokenIndex());


		token1.setRefreshToken("");

		tokenRepository.save(token1);
		return true;
	}

}
