package xxx.petmanbe.user.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


		return userRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException());
	}

	private UserDetails createUserDetails(User user){
		return User.builder()
				.username(user.getUsername())
				.password(passwordEncoder.encode(user.getPassword()))
				.roles(user.getAuthorities().toArray(new String[0]))
				.build();


	}
}
