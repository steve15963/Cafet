package xxx.petmanbe.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@Configuration
public class SercurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.formLogin().disable()
			.httpBasic().disable()
			// .authorizeRequests()
			// .antMatchers()
			.csrf().disable();

		return http.build();
	}

}
