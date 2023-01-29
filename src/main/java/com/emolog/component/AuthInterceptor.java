package com.emolog.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			String token = request.getHeader("authorization").split("Bearer ")[1];
			if (token == null || token == "") {
				response.sendError(401, "No Token Containing");
				return false;
			} else {
				// TODO: verify jwt token
				
				String decoded = "";
				request.setAttribute("auth", decoded);
				return true;
			}
//		return true;
	}
	
	boolean isValidAccessToken () {
		
		return true;
	}
}
