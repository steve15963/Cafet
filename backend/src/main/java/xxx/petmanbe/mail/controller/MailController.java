package xxx.petmanbe.mail.controller;

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
import xxx.petmanbe.mail.DTO.requestDto.KeyCheckRegistDto;
import xxx.petmanbe.mail.DTO.requestDto.MailCheckRegistDto;
import xxx.petmanbe.mail.service.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
@Tag(name = "메일 기능", description = "이메일 관련 API Docs")
@CrossOrigin("*")
public class MailController {

	private final MailService mailService;

	//회원가입 이메일 인증
	@PostMapping("/send/regist")
	@Operation(summary = "회원가입 이메일 전송하기")
	public ResponseEntity<String> postRegistMail(@RequestBody MailCheckRegistDto request){

		mailService.postRegistMail(request);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원가입 이메일 확인
	@PostMapping("/check/regist")
	@Operation(summary = "이메일 확인")
	public ResponseEntity<String> postRegistCheckMail(@RequestBody KeyCheckRegistDto request){

		mailService.postRegistCheckMail(request);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
