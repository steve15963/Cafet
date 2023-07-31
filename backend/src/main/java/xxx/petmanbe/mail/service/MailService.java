package xxx.petmanbe.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.mail.DTO.MailDto;

@Service
@Slf4j
public class MailService {
	private JavaMailSender mailSender;

	@Value("${spring.mail.properties.mail.sender}")
	private String FROM_ADDRESS;

	@Autowired
	public MailService(JavaMailSender mailSender) {
		if(mailSender == null)
			log.error("NO MailServer");
		this.mailSender = mailSender;
	}

	/**
	 * 메일 전송 서비스
	 * @param mailDto Address, subject, message를 가지는 객체
	 * @return 0. 성공, 1. 연결실패, 추가예정.
	 */
	public int mailSend(MailDto mailDto) {
		//메일서버 인스턴스가 없는 경우
		if(mailSender == null)
			return 1;
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getAddress());
		message.setFrom(FROM_ADDRESS);
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());
		mailSender.send(message);

		//성공적 종료
		return 0;
	}
	private String genRandomPassword(int length) {
		String password = "";
		for(int i = 0 ; i < length; i++) {
			password += (int)((Math.random() * 10) % 10);
		}
		return password;
	}

}
