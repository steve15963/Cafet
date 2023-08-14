package xxx.petmanbe.KioskLogin.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.KioskLogin.dto.responseDto.KioskLoginReturnDto;
import xxx.petmanbe.KioskLogin.service.KioskService;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.service.UserService;

@RestController
@RequestMapping(value="/api/kiosk/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class KioskLoginController {

	private final UserService userService;

	private final KioskService kioskService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) throws Exception {

		long shopId = -1;

		KioskLoginReturnDto kioskLoginReturnDto = kioskService.checkShop(loginDto);

		//accessToken이 됨

		if(Objects.isNull(kioskLoginReturnDto)){

			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

		}

		LoginReturnDto loginReturnDto = userService.postLoginUser(loginDto);



		// ResponseCookie cookie2 = ResponseCookie.from("accessToken", loginReturnDto.getToken().getAccessToken())
		// 	.maxAge(864000)
		// 	.path("/")
		// 	.secure(true)
		// 	.sameSite("None")
		// 	.httpOnly(true)
		// 	.build();

		httpServletResponse.addHeader("Authorization",loginReturnDto.getToken().getAccessToken());
		// httpServletResponse.setHeader("Set-Cookie",cookie1.toString()); //refreshToken
		//		httpServletResponse.addHeader("Set-Cookie",cookie2.toString()); // accessToken

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
