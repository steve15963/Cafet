package xxx.petmanbe.KioskLogin.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.KioskLogin.dto.responseDto.KioskLoginReturnDto;
import xxx.petmanbe.KioskLogin.service.KioskService;
import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.service.UserService;

@RestController
@RequestMapping(value="/api/kiosk/user")
@Tag(name = "키오스크 로그인", description = "키오스크 로그인 API Docs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class KioskLoginController {

	private final UserService userService;

	private final KioskService kioskService;

	@PostMapping("/login")
	@Operation(summary = "키오스크에서 로그인하기")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) throws Exception {

		KioskLoginReturnDto kioskLoginReturnDto = kioskService.checkShop(loginDto);

		//accessToken이 됨

		if(Objects.isNull(kioskLoginReturnDto)){

			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

		}

		LoginReturnDto loginReturnDto = userService.postLoginUser(loginDto);

		httpServletResponse.addHeader("Authorization",loginReturnDto.getToken().getAccessToken());

		//CORS
		httpServletResponse.setHeader("Acess-Control-Allow-origin","*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
		httpServletResponse.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE");

		if(Objects.isNull(loginReturnDto.getToken())){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(kioskLoginReturnDto ,HttpStatus.OK);
	}
}
