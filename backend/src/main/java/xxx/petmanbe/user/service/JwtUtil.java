package xxx.petmanbe.user.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import xxx.petmanbe.user.entity.User;

@Component
public class JwtUtil {

	@Value("${jwt.key}")
	private String key;

	@Value("${jwt.accessTokenExpirationTime:0}")
	private int accessTokenExpirationTime;

	@Value("${jwt.refreshTokenExpirationTime:0}")
	private int refreshTokenExpirationTime;

	public String generateAccessToken(User user){

		accessTokenExpirationTime=1000;

		return Jwts.builder()
			.claim("emailid",user.getEmail())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+accessTokenExpirationTime))
			.signWith(SignatureAlgorithm.HS256,key)
			.compact();
	}

	public String generateRefreshToken(User user){

		refreshTokenExpirationTime=1000;

		return Jwts.builder()
			.claim("emailid", user.getEmail())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+refreshTokenExpirationTime))
			.signWith(SignatureAlgorithm.HS256,key)
			.compact();

	}


}
