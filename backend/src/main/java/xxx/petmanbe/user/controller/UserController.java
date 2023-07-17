package xxx.petmanbe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.ModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/new")
	public ResponseEntity<String> PostNewUser(@RequestBody RegistDto registDto) throws Exception {

		String email = userService.postnewUser(registDto);

		return ResponseEntity.ok(email + "regist success");

	}


	@PostMapping("/login")
	public ResponseEntity<Token> PostLoginUser(@RequestBody LoginDto loginDto) throws Exception{

		Token token = userService.postLoginUser(loginDto);

		return ResponseEntity.ok(token);
	}

	@PutMapping("")
	public ResponseEntity<String> PutUser(@RequestBody ModifyDto modifyDto) throws Exception {

		String msg = userService.putUser(modifyDto);

		return ResponseEntity.ok(modifyDto.getEmail()+msg);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserInformationDto> GetUser(@PathVariable long userId) throws Exception {

		UserInformationDto userInformationDto = userService.getUser(userId);

		return ResponseEntity.ok(userInformationDto);

	}


}
