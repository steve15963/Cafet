package xxx.petmanbe.user.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RefreshTokenDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.service.JwtService;
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


	@PostMapping(value="/new")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto request) throws Exception {

		Long userId = userService.postnewUser(request);

		return new ResponseEntity<>(userId + "regist success",HttpStatus.OK);

	}

	@PostMapping("/login")
	// public ResponseEntity<RefreshJwtDto> PostLoginUser(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest) throws Exception{
	public ResponseEntity PostLoginUser(@RequestBody LoginDto request, HttpServletRequest httpServletRequest) throws Exception{
		// Optional<RefreshJwtDto> refreshJwtDto = userService.postLoginUser(loginDto);
		// if(refreshJwtDto.isEmpty()) {
		// 	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		//
		// }
		// return new ResponseEntity<RefreshJwtDto>(refreshJwtDto.get(), HttpStatus.OK);
		User findUser = userService.SessionLogin(request);

		httpServletRequest.getSession().setAttribute("user",
			findUser
		);
		if(Objects.isNull(findUser)) {
			return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<>("",HttpStatus.OK);
	}

	//이메일은 못 바꿈
	@PutMapping(value="")
	public ResponseEntity<String> PutUser(@RequestBody UserModifyDto request) throws Exception {

		String userFile = null;

		if(userService.putUser(request)){
			if(!request.getFileUrl().isEmpty()){
				userFile = fileService.keepFile(request.getFileUrl(), request.getEmail());
			}
		}

		return new ResponseEntity<>(userFile,HttpStatus.OK);
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
	public ResponseEntity<String> PostRefreshToken(@RequestBody RefreshTokenDto request){

		String newAccessToken = jwtService.refreshToken(request.getRefreshToken());

		return new ResponseEntity<>(newAccessToken,HttpStatus.OK);

	}
	
	
	// level 내리기
	@PutMapping("/level")
	public ResponseEntity<String> PutUserLevel(@RequestBody LevelModifyDto request){

		String msg = userService.putUserLevel(request);

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}


}

