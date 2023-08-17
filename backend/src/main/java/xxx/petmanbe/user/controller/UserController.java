package xxx.petmanbe.user.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.requestDto.UpdateUserPasswordDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.service.JwtService;
import xxx.petmanbe.user.service.UserService;
import xxx.petmanbe.userfile.service.FileService;

@RestController
@RequestMapping(value="/api/user")
@Tag(name = "사용자", description = "사용자 API Docs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

	private final UserService userService;
	private final JwtService jwtService;

	private final FileService fileService;

	@Value("${jwt.accessTokenExpirationTime.int}")
	private int accessTokenExpirationTime;

	@Value("${jwt.refreshTokenExpirationTime.int}")
	private int refreshTokenExpirationTime;

	@PostMapping(value="/new")
	@Operation(summary = "회원가입")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto request) throws Exception {

		Long userId = userService.postnewUser(request);

		return new ResponseEntity<>(userId + "regist success",HttpStatus.OK);

	}

	@PostMapping("/login")
	@Operation(summary = "로그인")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) throws Exception {

		LoginReturnDto loginReturnDto = userService.postLoginUser(loginDto);

		ResponseCookie cookie1 = ResponseCookie.from("refreshToken", loginReturnDto.getToken().getRefreshToken())
				.maxAge(accessTokenExpirationTime)
				.path("/")
				.secure(true)
				.sameSite("None")
				.httpOnly(true)
				.build();

		ResponseCookie.from("accessToken", loginReturnDto.getToken().getAccessToken())
			.maxAge(refreshTokenExpirationTime)
			.path("/")
			.secure(true)
			.sameSite("None")
			.httpOnly(true)
			.build();

		httpServletResponse.addHeader("Authorization",loginReturnDto.getToken().getAccessToken());
		httpServletResponse.setHeader("Set-Cookie",cookie1.toString()); //refreshToken

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
	@Operation(summary = "리프레시 토큰 재발급")
	public ResponseEntity<?> PostRefreshToken(@RequestHeader(value = "Cookie") String refreshToken, HttpServletResponse response){
		//header에서 client에서 보낸 refreshToken cookie를 받는다.(client 에서 header에서 Cookie로 설정)

		String[] token= refreshToken.split("; ");

		for (String s : token) {
			if (s.startsWith("refreshToken")) {
				refreshToken = s.substring(13);
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
				.secure(true)
				.sameSite("None")
				.httpOnly(true)
				.build();

			response.setHeader("Set-Cookie",cookie.toString());


			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			// 재 로그인 해야 함
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/logout")
	@Operation(summary = "로그아웃")
	public ResponseEntity<?> PostLogout(HttpServletRequest request, HttpServletResponse response){

		userService.postLogout(request);


		ResponseCookie cookie = ResponseCookie.from("refreshToken",null)
			.maxAge(1)
			.path("/")
			.sameSite("None")
			.secure(true)
			.httpOnly(true)
			.build();

		response.setHeader("Set-Cookie",cookie.toString());

		return new ResponseEntity<>(cookie.getName(),HttpStatus.OK);

	}

	// 비밀번호 변경
	@PutMapping("/changepassword")
	@Operation(summary = "비밀번호 변경하기")
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
	@Operation(summary = "회원 정보 수정하기")
	public ResponseEntity<String> PutUser(@RequestPart(value="dto") UserModifyDto request, @RequestPart(value="file") MultipartFile file) throws Exception {

		String userFile = null;

		if(userService.putUser(request)){
			if(!file.isEmpty()){
				userFile = fileService.keepFile(file, request.getEmail());
			}
		}

		return new ResponseEntity<>(userFile,HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('USER','SHOP','ADMIN')")
	@GetMapping("/{userId}")
	@Operation(summary = "사용자 정보 상세보기")
	public ResponseEntity<UserInformationDto> GetUser(@PathVariable long userId) throws Exception {

		UserInformationDto userInformationDto = userService.getUser(userId);

		return new ResponseEntity<>(userInformationDto,HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get")
	@Operation(summary = "사용자 목록 전체 보기")
	public ResponseEntity<List<UserListDto>> GetUserList(){

		List<UserListDto> userList = userService.getUserList();

		return new ResponseEntity<>(userList,HttpStatus.OK);

	}

	@DeleteMapping("/{userId}")
	@Operation(summary = "회원 탈퇴/복구하기")
	public ResponseEntity<String> DeleteUser(@PathVariable long userId){

		String msg = userService.deleteUser(userId);

		return new ResponseEntity<>(msg,HttpStatus.OK);

	}
	
	// level 내리기
	@PutMapping("/level")
	@Operation(summary = "사용자 권한 내리기")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto request){

		String msg = userService.putUserLevel(request);

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	// 관리자 기능: 이메일로 검색
	@GetMapping("/get/email/{email}")
	@Operation(summary = "이메일로 사용자 검색하기")
	public ResponseEntity<List<UserListDto>> getUserListByEmail(@PathVariable String email){

		// 목록 받아오기
		List<UserListDto> userList = userService.getUserListByEmail(email);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	// 관리자 기능: 닉네임으로 검색
	@GetMapping("/get/nickname/{nickname}")
	@Operation(summary = "닉네임으로 사용자 검색하기")
	public ResponseEntity<List<UserListDto>> getUserListByNickname(@PathVariable String nickname){

		// 목록 받아오기
		List<UserListDto> userList = userService.getUserListByNickname(nickname);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	// 해당 게시글 좋아요 여부
	@GetMapping("/{userId}/likeBoard/{boardId}")
	@Operation(summary = "해당 유저의 해당 게시글 좋아요 여부 확인하기")
	public ResponseEntity<Boolean> checkUserLikeBoard(@PathVariable Long userId, @PathVariable Long boardId){

		return new ResponseEntity<>(userService.checkUserLikeBoard(userId, boardId), HttpStatus.OK);
	}

	// 해당 가게 좋아요 여부
	@GetMapping("/{userId}/likeShop/{shopId}")
	@Operation(summary = "해당 유저의 해당 가게 팔로우 여부 확인하기")
	public ResponseEntity<Boolean> checkUserLikeShop(@PathVariable Long userId, @PathVariable Long shopId){

		return new ResponseEntity<>(userService.checkUserLikeShop(userId, shopId), HttpStatus.OK);
	}
}

