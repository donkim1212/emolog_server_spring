package com.emolog.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.emolog.component.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("--AuthInterceptor");
		try {
			String header = request.getHeader("authorization");
			if (header == null || header == "") {
				response.sendError(401, "No JWT token found in the header.");
				return false;
			} else {
				// TODO: verify jwt token
				String token = header.substring(7); // get rid of "Bearer "
				String decoded = JwtUtils.verify(token);
				request.setAttribute("auth", decoded);
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.sendError(401, "An error occurred while authenticating JWT token.");
			return false;
		}
	}
	
	/*
	boolean isValidAccessToken (String token) {
		
		return true;
	}
	*/
}
