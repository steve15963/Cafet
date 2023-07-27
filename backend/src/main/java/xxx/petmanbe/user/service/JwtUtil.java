package xxx.petmanbe.user.service;

import java.sql.Date;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Component
public class JwtUtil {

	@Value("${jwt.key}")
	private String key;

	@Value("${jwt.accessTokenExpirationTime:0}")
	private int accessTokenExpirationTime;

	@Value("${jwt.refreshTokenExpirationTime:0}")
	private int refreshTokenExpirationTime;

	@Autowired
	private UserRepository userRepository;

	public String generateAccessToken(User user){

		accessTokenExpirationTime=120000;

		return Jwts.builder()
				.claim("emailid",user.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+accessTokenExpirationTime))
				.signWith(SignatureAlgorithm.HS256,key.getBytes())
				.compact();
	}

	public String generateRefreshToken(User user){

		refreshTokenExpirationTime=120000;

		return Jwts.builder()
				.claim("emailid", user.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+refreshTokenExpirationTime))
				.signWith(SignatureAlgorithm.HS256,key.getBytes())
				.compact();

	}

	//-----------------------


	//-----------------------

	public String getAccessToken(Long userId){

		User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());

		return generateAccessToken(user);

	}

	public String getRefreshToken(Long userId){

		User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException());

		return generateRefreshToken(user);
	}

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
