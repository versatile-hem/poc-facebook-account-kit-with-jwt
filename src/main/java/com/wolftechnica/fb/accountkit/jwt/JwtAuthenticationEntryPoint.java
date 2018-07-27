package com.wolftechnica.fb.accountkit.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Hem Chand
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse arg1,
			org.springframework.security.core.AuthenticationException arg2) throws IOException, ServletException {
		arg1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED " + arg2.getMessage());
	}
}
