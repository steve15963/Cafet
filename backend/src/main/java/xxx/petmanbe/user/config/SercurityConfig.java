package xxx.petmanbe.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SercurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.formLogin().disable()
			.httpBasic().disable()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers().permitAll() // 해당 api에서는 모든 요청을 허가한다는 설정
				.anyRequest().authenticated(); // 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
//				.and()
//				.addFilterBefore()

			// .authorizeRequests()
			// .antMatchers("/api/user/~~").hasRole("ADMIN") // user일때 실행

		return http.build();
	}

}
