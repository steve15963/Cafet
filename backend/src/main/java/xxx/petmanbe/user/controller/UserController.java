package xxx.petmanbe.user.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.mail.service.MailService;
import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UpdateUserPasswordDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.RefreshJwtDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.service.JwtService;
import xxx.petmanbe.user.service.JwtUtil;
import xxx.petmanbe.user.service.UserService;
import xxx.petmanbe.userfile.service.FileService;

@RestController
@RequestMapping(value="/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

	private final UserService userService;
	private final JwtService jwtService;

	private final FileService fileService;

	private final MailService mailService;

	private final JwtUtil jwtUtil;

	@Value("${jwt.accessTokenExpirationTime.int}")
	private int accessTokenExpirationTime;

	@Value("${jwt.refreshTokenExpirationTime.int}")
	private int refreshTokenExpirationTime;

	@PostMapping(value="/new")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto request) throws Exception {

		Long userId = userService.postnewUser(request);

		return new ResponseEntity<>(userId + "regist success",HttpStatus.OK);


		// 추후에 넣어야 할 부분 (지금은 체크하기 불편할까봐 주석으로 넣어놓음)
		// if(mailService.registcheck(request.getEmail())){
		// 	Long userId = userService.postnewUser(request);
		// 	return new ResponseEntity<>(userId + "regist success",HttpStatus.OK);
		//
		// }else{
		// 	return new ResponseEntity<>("다시 인증해주세요!", HttpStatus.OK);
		// }

	}

	@PostMapping("/test")
	public String test(){
		return "success";
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) throws Exception {

		LoginReturnDto loginReturnDto = userService.postLoginUser(loginDto);

		ResponseCookie cookie1 = ResponseCookie.from("refreshToken", loginReturnDto.getToken().getRefreshToken())
				.maxAge(accessTokenExpirationTime)
				.path("/")
				.secure(true)
				.sameSite("None")
				.httpOnly(true)
				.build();

		ResponseCookie cookie2 = ResponseCookie.from("accessToken", loginReturnDto.getToken().getAccessToken())
				.maxAge(refreshTokenExpirationTime)
				.path("/")
				.secure(true)
				.sameSite("None")
				.httpOnly(true)
				.build();

		httpServletResponse.addHeader("Authorization",loginReturnDto.getToken().getRefreshToken());
		httpServletResponse.setHeader("Set-Cookie",cookie1.toString()); //refreshToken
		httpServletResponse.addHeader("Set-Cookie",cookie2.toString()); // accessToken

		//CORS
		httpServletResponse.setHeader("Acess-Control-Allow-origin","*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
		httpServletResponse.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE");

		if(Objects.isNull(loginReturnDto.getToken())){

			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(loginReturnDto.getLoginResponseDto(),HttpStatus.OK);
	}

	// refreshToken이 유효한지 확인 -> 유효하면 엑세스 토큰 반환
	// 유효하지 않으면 재 로그인
	@PostMapping("/token/refresh")
	public ResponseEntity<?> PostRefreshToken(@RequestHeader(value = "Cookie") String refreshToken, HttpServletResponse response){
		//header에서 client에서 보낸 refreshToken cookie를 받는다.(client 에서 header에서 Cookie로 설정)

		String[] token= refreshToken.split("; ");

		for(int i=0 ; i<token.length ; i++) {
			if(token[i].substring(0,12).equals("refreshToken")){
				refreshToken=token[i].substring(13);
			}
		}

		String newAccessToken = jwtService.refreshToken(refreshToken);

		response.setHeader("Acess-Control-Allow-origin","*");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE");

		if(!Objects.isNull(newAccessToken)){
			ResponseCookie cookie = ResponseCookie.from("accessToken", newAccessToken)
				.maxAge(accessTokenExpirationTime)
				.path("/")
				//.secure(true)
				.sameSite("None")
				//.httpOnly(true)
				.build();

			response.setHeader("Set-Cookie",cookie.toString());


			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			// 재 로그인 해야 함
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	// 비밀번호 변경
	@PutMapping("/changepassword")
	public ResponseEntity<String> putUserPassword(@RequestBody UpdateUserPasswordDto request){

		// 만약 변경이 되면
		if (userService.changeUserPassword(request)){
			return new ResponseEntity<>("success!", HttpStatus.OK);
		}

		// 안되면
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
	}


	//이메일은 못 바꿈
	@PutMapping(value="")
	public ResponseEntity<String> PutUser(@RequestPart(value="dto") UserModifyDto request, @RequestPart(value="file") MultipartFile file) throws Exception {

		String userFile = null;

		if(userService.putUser(request)){
			if(!file.isEmpty()){
				userFile = fileService.keepFile(file, request.getEmail());
			}
		}

		return new ResponseEntity<>(userFile,HttpStatus.OK);
	}

	// @PreAuthorize("hasAnyRole('USER','SHOP','ADMIN')")
	@GetMapping("/{userId}")
	public ResponseEntity<UserInformationDto> GetUser(@PathVariable long userId) throws Exception {

		UserInformationDto userInformationDto = userService.getUser(userId);

		return new ResponseEntity<>(userInformationDto,HttpStatus.OK);

	}

	// @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<UserListDto>> GetUserList(){

		List<UserListDto> userList = userService.getUserList();

		return new ResponseEntity<>(userList,HttpStatus.OK);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> DeleteUser(@PathVariable long userId){

		String msg = userService.deleteUser(userId);

		return new ResponseEntity<>(msg,HttpStatus.OK);

	}
	
	// level 내리기
	@PutMapping("/level")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto request){

		String msg = userService.putUserLevel(request);

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	// 관리자 기능: 이메일로 검색
	@GetMapping("/email/{email}")
	public ResponseEntity<List<UserListDto>> getUserListByEmail(@PathVariable String email){

		// 목록 받아오기
		List<UserListDto> userList = userService.getUserListByEmail(email);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	// 관리자 기능: 닉네임으로 검색
	@GetMapping("/nickname/{nickname}")
	public ResponseEntity<List<UserListDto>> getUserListByNickname(@PathVariable String nickname){

		// 목록 받아오기
		List<UserListDto> userList = userService.getUserListByNickname(nickname);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
}

