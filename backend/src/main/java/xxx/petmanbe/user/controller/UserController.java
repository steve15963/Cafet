package xxx.petmanbe.user.controller;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.LoginRequestDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.service.JwtService;
import xxx.petmanbe.user.service.UserService;

@RestController
@RequestMapping(value="/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final JwtService jwtService;

	@PostMapping("/new")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto registDto) throws Exception {

		String email = userService.postnewUser(registDto);

		return new ResponseEntity<>(email + "regist success",HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<String> PostLoginUser(@RequestBody LoginDto loginDto) throws Exception{

		if(userService.postLoginUser(loginDto)){
				return new ResponseEntity<>("success", HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("")
	public ResponseEntity<String> PutUser(@RequestBody UserModifyDto userModifyDto) throws Exception {

		String msg = userService.putUser(userModifyDto);

		return new ResponseEntity<>(userModifyDto.getEmail()+msg,HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserInformationDto> GetUser(@PathVariable long userId) throws Exception {

		UserInformationDto userInformationDto = userService.getUser(userId);

		return new ResponseEntity<>(userInformationDto,HttpStatus.OK);

	}

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

	@PostMapping("/token/refresh")
	public ResponseEntity<String> PostRefreshToken(@RequestBody RefreshTokenDto refreshTokenDto){

		String newAccessToken = jwtService.refreshToken(refreshTokenDto.getRefreshToken());

		return new ResponseEntity<>(newAccessToken,HttpStatus.OK);

	}

	@PutMapping("/level")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto levelModifyDto){

		String msg = userService.putUserLevel(levelModifyDto);

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}


}
