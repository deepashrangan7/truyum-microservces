package com.cts.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private String secret = "codelikeapro";

//	public String generateToken(String username, String role) {
//		Map<String, Object> claims = new HashMap<>();
//
//		return createToken(claims, username, role);
//	}

//	private String createToken(Map<String, Object> claims, String username, String role) {
////		Claims
//
//		return Jwts.builder().setClaims(claims).setSubject(username).setAudience(role)
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 10)))
//				.signWith(SignatureAlgorithm.HS256, secret).compact();
//
//	}

//	1000 * 60 * 60 * 
//	public boolean validateToken(String token, UserDetails userDetails) {
//		final String username = extractUsername(token);
//		try {
//			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//		} catch (Exception e) {
//			return false;
//			// TODO: handle exception
//		}
//	}

	public String extractUsername(String token) {
		try {

			return extractClaim(token, Claims::getSubject);

		} catch (Exception e) {

			return null;
		}
	}

//	private Date extractExpiration(String token) {
//		return extractClaim(token, Claims::getExpiration);
//	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

//	private boolean isTokenExpired(String token) {
//
//		return extractExpiration(token).before(new Date());
//	}

	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

}
