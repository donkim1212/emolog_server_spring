package com.emolog.component;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class JwtAuthFilter extends AbstractAuthenticationProcessingFilter {
	public JwtAuthFilter() {
		super("/**");
	}
	
	@Override
	public boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		return true;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenMissingException("No JWT token found in request headers.");
		}
		
		String token = header.substring(7);
		String decoded = JwtUtils.verify(token);
		
//		JwtAuthenticationToken authRequest = new JwtAuthenticationToken(token);
//		getAuthenticationManager().authenticate(authRequest);
		return null;
	}
	
	
}
