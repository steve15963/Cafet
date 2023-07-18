package xxx.petmanbe.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.LoginRequestDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.service.JwtService;
import xxx.petmanbe.user.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	private final UserService userService;
	private final JwtService jwtService;

	public UserController(UserService userService, JwtService jwtService){
		this.userService = userService;
		this.jwtService=jwtService;
	}

	@PostMapping("/new")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto registDto) throws Exception {

		String email = userService.postnewUser(registDto);

		return ResponseEntity.ok(email + "regist success");

	}

	@PostMapping("/login")
	public ResponseEntity<LoginRequestDto> PostLoginUser(@RequestBody LoginDto loginDto) throws Exception{

		LoginRequestDto loginRequestDto = userService.postLoginUser(loginDto);

		return ResponseEntity.ok(loginRequestDto);
	}

	@PutMapping("")
	public ResponseEntity<String> PutUser(@RequestBody UserModifyDto userModifyDto) throws Exception {

		String msg = userService.putUser(userModifyDto);

		return ResponseEntity.ok(userModifyDto.getEmail()+msg);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserInformationDto> GetUser(@PathVariable long userId) throws Exception {

		UserInformationDto userInformationDto = userService.getUser(userId);

		return ResponseEntity.ok(userInformationDto);

	}

	@GetMapping("")
	public ResponseEntity<List<UserListDto>> GetUserList(){

		List<UserListDto> userList = userService.getUserList();

		return ResponseEntity.ok(userList);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> DeleteUser(@PathVariable long userId){

		String msg = userService.deleteUser(userId);

		return ResponseEntity.ok(msg);

	}

	@PostMapping("/token/refresh")
	public ResponseEntity<String> PostRefreshToken(@RequestBody RefreshTokenDto refreshTokenDto){

		String newAccessToken = jwtService.refreshToken(refreshTokenDto.getRefreshToken());

		return ResponseEntity.ok(newAccessToken);

	}

	@PutMapping("/level")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto levelModifyDto){

		String msg = userService.putUserLevel(levelModifyDto);

		return ResponseEntity.ok(msg);
	}


}
