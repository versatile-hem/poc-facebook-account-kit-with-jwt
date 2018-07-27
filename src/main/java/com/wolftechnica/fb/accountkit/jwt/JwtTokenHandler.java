package com.wolftechnica.fb.accountkit.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This class uses JJWT api by stormpath
 * 
 * @author b0202777
 */
@Component
public class JwtTokenHandler {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.validity}")
	private long jwtValidity;

	public String generate(String username, String role) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("role", role);
		return Jwts.builder().setExpiration(new Date(System.currentTimeMillis() + jwtValidity)).setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public JwtUserDetails validate(String token) {
		JwtUserDetails jwtUserDetails = null;
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

			jwtUserDetails = new JwtUserDetails(body.getSubject(), token, (String) body.get("role"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jwtUserDetails;
	}
}
