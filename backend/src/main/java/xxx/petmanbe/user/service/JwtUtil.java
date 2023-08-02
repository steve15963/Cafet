package xxx.petmanbe.user.service;

import java.sql.Date;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class JwtUtil {

	@Value("${jwt.key}")
	private String key;

	@Value("${jwt.accessTokenExpirationTime.int}")
	private int accessTokenExpirationTime;

	@Value("${jwt.refreshTokenExpirationTime.int}")
	private int refreshTokenExpirationTime;

	private final UserRepository userRepository;

	private final UserDetailsService userDetailsService;


	// 객체 초기화, secreKey를 Base64로 인코딩한다.
	@PostConstruct
	protected void init(){
		key = Base64.getEncoder().encodeToString(key.getBytes());
	}

	public String generateAccessToken(String email, List<String> roles){

		Claims claims = Jwts.claims().setSubject(email);
		claims.put("roles",roles);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+accessTokenExpirationTime))
				.signWith(SignatureAlgorithm.HS256,key)
				.compact();
	}

	public String generateRefreshToken(String email){


		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+refreshTokenExpirationTime))
				.signWith(SignatureAlgorithm.HS256,key)
				.compact();

	}

	//-----------------------
	public Cookie createCookie(String email){

		ResponseCookie cookie = ResponseCookie.from("refreshToken",refresh)
			.maxAge()
			.path("/")
			.sameSite("None")
			.httpOnly(true)
			.build();

		String cookieName = "refreshtoken";
		String cookieValue = generateRefreshToken(email);

		Cookie cookie = new Cookie(cookieName,cookieValue);

		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setPath("/");
		cookie.setMaxAge(refreshTokenExpirationTime);
		return cookie;

	}

	//-----------------------

	// public String getAccessToken(Long userId){
	//
	// 	User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());
	//
	// 	return generateAccessToken(user);
	//
	// }

	// JWT 토큰에서 인증 정보 조회
	public Authentication getAuthentication(String token){

		UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));

		return new UsernamePasswordAuthenticationToken(userDetails, "",userDetails.getAuthorities());
	}

	//토큰에서 회원 정보 추출
	public String getUserPk(String token){
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
	}

	//Request의 Header에서 token 값을 가져온다. "Authorization":"Token값"
	public String resolveToken(HttpServletRequest request){
		return request.getHeader("Authorization");
	}

	// public String getRefreshToken(Long userId){
	//
	// 	User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());
	//
	// 	return generateRefreshToken(user);
	// }

	public Boolean validateToken(String token){

		try {
			System.out.println(key.getBytes());
			Claims claims = Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(token).getBody();
			return true;
		} catch(SignatureException ex){
			//			System.out.println(Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(token));
			System.out.println("Invalid JWT signautre");
		} catch(MalformedJwtException ex){
			System.out.println("Invalid JWT token");
		} catch(ExpiredJwtException ex){
			System.out.println("Expired JWT token");
		} catch(UnsupportedJwtException ex){
			System.out.println("Unsupported JWT token");
		} catch(IllegalArgumentException ex){
			System.out.println("JWT claims string is empty");
		}
		return false;



	}



}
