package com.emolog.component;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {

	private static final long serialVersionUID = 1234567L;

	public JwtTokenMissingException(String msg) {
		super(msg);
	}

}
