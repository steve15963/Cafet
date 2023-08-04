package xxx.petmanbe.user.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.checkerframework.checker.units.qual.C;
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
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
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

	@PostMapping("/login/1")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) throws Exception {

		Token token = userService.postLoginUser(loginDto);

		ResponseCookie cookie1 = ResponseCookie.from("refreshToken", token.getRefreshToken())
				.maxAge(3000)
				.path("/")
//				.secure(true)
				.sameSite("None")
//				.httpOnly(true)
				.build();

		ResponseCookie cookie2 = ResponseCookie.from("AccessToken", token.getAccessToken())
				.maxAge(3000)
				.path("/")
//				.secure(true)
				.sameSite("None")
//				.httpOnly(true)
				.build();



		httpServletResponse.addHeader("Authorization",token.getRefreshToken());
		httpServletResponse.setHeader("Set-Cookie",cookie1.toString()); //refreshToken
		httpServletResponse.setHeader("Access", cookie2.toString()); // AccessToken

		if(Objects.isNull(token)){

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(token.getAccessToken(), HttpStatus.OK);
	}


	// @PostMapping("/login")
	// // public ResponseEntity<RefreshJwtDto> PostLoginUser(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest) throws Exception{
	// public ResponseEntity PostLoginUser(@RequestBody LoginDto request, HttpServletRequest httpServletRequest) throws Exception{
	// 	// Optional<RefreshJwtDto> refreshJwtDto = userService.postLoginUser(loginDto);
	// 	// if(refreshJwtDto.isEmpty()) {
	// 	// 	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	// 	//
	// 	// }
	// 	// return new ResponseEntity<RefreshJwtDto>(refreshJwtDto.get(), HttpStatus.OK);
	// 	User findUser = userService.SessionLogin(request);
	//
	// 	httpServletRequest.getSession().setAttribute("user",
	// 		findUser
	// 	);
	// 	if(Objects.isNull(findUser)) {
	// 		return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
	// 	}
	// 	else
	// 		return new ResponseEntity<>("",HttpStatus.OK);
	// }

	//이메일은 못 바꿈
	@PutMapping(value="", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

	// refreshToken이 유효한지 확인 -> 유효하면 엑세스 토큰 반환
	// 유효하지 않으면 재 로그인
	@PostMapping("/token/refresh")
	public ResponseEntity<?> PostRefreshToken(@RequestHeader(value = "Refresh") String refreshToken, HttpServletResponse response){

		String newAccessToken = jwtService.refreshToken(refreshToken);

		ResponseCookie cookie = ResponseCookie.from("accessToken", newAccessToken)
				.maxAge(300000)
				.path("/")
//				.secure(true)
				.sameSite("None")
//				.httpOnly(true)
				.build();

		response.setHeader("Set-Cookie",cookie.toString());

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	
	// level 내리기
	@PutMapping("/level")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto request){

		String msg = userService.putUserLevel(request);

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}


}

