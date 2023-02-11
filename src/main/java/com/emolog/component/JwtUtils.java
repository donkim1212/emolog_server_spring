package com.emolog.component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.security.

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {
	@Value("${JWT_SECRET}")
	private static String jwtSecret;
	private static Algorithm alg = Algorithm.HMAC256(jwtSecret);
	
	private static JWTVerifier verifier = JWT.require(alg)
			.withIssuer("Emolog")
			.build();
	
	private static final long accessTokenExpiresInSeconds = 1800L; // 30 minutes
	private static final long refreshTokenExpiresInSeconds = 31536000L; // 365 days

	/**
	 * 
	 * @param token
	 * @return NULL if verification failed
	 */
	public static String verify(String token) {
		try {
			DecodedJWT decodedJwt = verifier.verify(token);
			return decodedJwt.getPayload();
		} catch (JWTVerificationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param user_id
	 * @param mode
	 * @return NULL if creation failed
	 */
	public static String create(String user_id, JwtTokenMode mode) {
		// TODO user_id verification?
		long expModifier = 1L;
		if (mode == JwtTokenMode.ACCESS) {
			expModifier = accessTokenExpiresInSeconds;
		}
		else if (mode == JwtTokenMode.REFRESH) {
			expModifier = refreshTokenExpiresInSeconds;
		}
		try {
			String token = JWT.create()
					.withIssuer("Emolog")
					.withClaim("user_id", user_id)
					.withIssuedAt(new Date(System.currentTimeMillis()))
					.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * expModifier))
					.sign(alg);
			return token;
		} catch (JWTVerificationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
}
