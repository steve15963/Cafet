package xxx.petmanbe.mail.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.mail.DTO.MailDto;
import xxx.petmanbe.mail.DTO.requestDto.KeyCheckRegistDto;
import xxx.petmanbe.mail.DTO.requestDto.MailCheckRegistDto;
import xxx.petmanbe.mail.entity.RegistMail;
import xxx.petmanbe.mail.repository.MailRegistRepository;

@Service
@Slf4j
public class MailService {
	private final JavaMailSender mailSender;

	private final MailRegistRepository mailRegistRepository;

	@Value("${spring.mail.properties.mail.sender}")
	private String FROM_ADDRESS;

	@Value("${mail.regist.ExpirationTime.int}")
	private int registExpirationTime;

	@Value("${mail.regist.CheckExpirationTime.int}")
	private int registCheckExpirationTime;

	@Autowired
	public MailService(JavaMailSender mailSender, MailRegistRepository mailRegistRepository) {
		this.mailRegistRepository = mailRegistRepository;
		if(mailSender == null)
			throw new RestApiException(CommonErrorCode.BAD_REQUEST);
		this.mailSender = mailSender;
	}

	/**
	 * 메일 전송 서비스
	 * @param mailDto Address, subject, message를 가지는 객체
	 * @return 0. 성공, 1. 연결실패, 추가예정.
	 */
	public boolean mailSend(MailDto mailDto) {
		//메일서버 인스턴스가 없는 경우
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getMail());
		message.setFrom(FROM_ADDRESS);
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());

		System.out.println(FROM_ADDRESS);
		System.out.println(mailDto.getMessage());
		System.out.println(mailDto.getMail());
		mailSender.send(message);

		//성공적 종료
		return true;
	}
	
	//회원가입 인증번호 주기
	public boolean postRegistMail(MailCheckRegistDto mailCheckRegistDto){

		String Key = genRandomPassword(6);

		String message = "인증번호는 "+Key+" 입니다!";

		MailDto mailDto = MailDto.builder()
			.mail(mailCheckRegistDto.getMail())
			.title("[Cafet] 회원가입 인증번호입니다!")
			.message(message)
			.build();

		RegistMail registMail = RegistMail.builder()
			.mail(mailCheckRegistDto.getMail())
			.mailToken(Key)
			.expiredTime(LocalDateTime.now().plusMinutes(registExpirationTime))
			.build();

		mailRegistRepository.save(registMail);

		return mailSend(mailDto);
	}

	public boolean postRegistCheckMail(KeyCheckRegistDto keyCheckRegistDto){

		RegistMail registMailCheck = mailRegistRepository.findByMailTokenAndMail(keyCheckRegistDto.getMailToken(), keyCheckRegistDto.getMail());

		if (!Objects.isNull(registMailCheck)) {
			// expiration time이 now보다 시간이 작으면
			if (LocalDateTime.now().isBefore(registMailCheck.getExpiredTime())) {
				//성공
				registMailCheck.setCheckConfirm(true);
				registMailCheck.setCheckExpiredTime(LocalDateTime.now().plusHours(registCheckExpirationTime));

				return true;
			}

		}
		throw new RestApiException(CommonErrorCode.BAD_REQUEST);

	}

	// 회원가입 버튼을 눌렀을 때에 체크하는 함수
	public boolean registCheck(String email){

		RegistMail registMail = mailRegistRepository.findByMail(email)
			.orElseThrow(()-> new RestApiException(CommonErrorCode.BAD_REQUEST));

		return registMail.isCheckConfirm() && LocalDateTime.now().isBefore(registMail.getCheckExpiredTime());
	}


	//비밀번호 code를 랜덤으로 생성하는 함수
	private String genRandomPassword(int length) {
		StringBuilder password = new StringBuilder();
		for(int i = 0 ; i < length; i++) {
			password.append((int)((Math.random() * 10) % 10));
		}
		return password.toString();
	}
	
	

}
