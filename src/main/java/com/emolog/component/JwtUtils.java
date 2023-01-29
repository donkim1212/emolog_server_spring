package com.emolog.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	@Value("${JWT_SECRET}")
	private String jwtSecret;

	public String verify(String token) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		// claims.getBody().get(key, class) ... where key = string, class = SomeClass.class
		
		return "";
	}
}
