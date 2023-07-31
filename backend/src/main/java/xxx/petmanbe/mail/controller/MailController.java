package xxx.petmanbe.mail.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.mail.DTO.requestDto.KeyCheckRegistDto;
import xxx.petmanbe.mail.DTO.requestDto.MailCheckRegistDto;
import xxx.petmanbe.mail.service.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {

	private final MailService mailService;

	//회원가입 이메일 인증
	@PostMapping("/send/regist")
	public ResponseEntity<String> postRegistMail(@RequestPart("dto") MailCheckRegistDto request){

		if(mailService.postRegistMail(request)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}


	//회원가입 이메일 확인
	@PostMapping("/check/regist")
	public ResponseEntity<String> postRegistCheckMail(@RequestPart("dto") KeyCheckRegistDto request){

		if(mailService.postRegistCheckMail(request)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
