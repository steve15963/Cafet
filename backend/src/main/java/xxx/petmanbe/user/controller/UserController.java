package xxx.petmanbe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xxx.petmanbe.user.dto.requestDto.RegistDto;
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



}
