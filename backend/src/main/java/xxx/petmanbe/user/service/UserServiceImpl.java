package xxx.petmanbe.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;




	@Override
	public String postnewUser(RegistDto registDto) throws Exception {

		User user = User.builder()
			.email(registDto.getEmail())
			.password(registDto.getPassword())
			.phoneNo(registDto.getPhoneNo())
			.nickname(registDto.getNickname())
			.level(100)
			.status("no")
			.createdDate(LocalDateTime.now())
			.updatedDate(LocalDateTime.now())
			.build();

		String email = userRepository.save(user).getEmail();

		return email;
	}
}
