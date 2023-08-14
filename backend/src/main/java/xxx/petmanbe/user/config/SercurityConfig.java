package xxx.petmanbe.user.config;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.service.JwtUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SercurityConfig {

	private final JwtUtil jwtUtil;

	@Value("${jwt.whiteList}")
	private String[] whiteList;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.formLogin().disable()
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			//아랫줄 대체
			//화이트 리스트의 모든 url패스.
			.antMatchers().permitAll()
			// .antMatchers("/swagger/**","/swagger-resources/**","/health","/v3/api-docs/**","/swagger-ui/**","/api/boardfile/**","/api/user/logout","/api/user/login/**", "/api/user/new/**","/api/board/**","/api/shop/**").permitAll() // 해당 api에서는 모든 요청을 허가한다는 설정
			.antMatchers("/api/user/get").access("hasRole('ADMIN')") // ADMIN일때 실행
			// .anyRequest().authenticated() // 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
			.and()
			.addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);



		// .authorizeRequests()
		// .antMatchers("/api/user/~~").hasRole("ADMIN") // user일때 실행

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
