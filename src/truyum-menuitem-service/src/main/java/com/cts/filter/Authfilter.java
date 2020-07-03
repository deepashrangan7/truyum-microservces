package com.cts.filter;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cts.feign.AuthenticationServiceFeign;
import com.cts.modal.TempStore;
import com.cts.modal.Users;
import com.cts.service.CustomerUserService;
import com.cts.service.JwtService;

@Component
public class Authfilter extends OncePerRequestFilter {
	@Autowired
	private AuthenticationServiceFeign asf;
	@Autowired
	private CustomerUserService service;

	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {
		boolean flag = false;
		String token = null;
		try {
			token = request.getHeader("Authorization").substring(7);
//			System.out.println(token);
			flag = asf.validate(request.getHeader("Authorization"));

		} catch (Exception e) {
			System.out.println("error ocuured " + e.getMessage());
		}
		if (flag) {
			HttpSession session = Authfilter.session();
			String user = TempStore.username;
//			System.out.println(" user in auth " + TempStore.username);
			if (user == null) {
				user = jwtService.extractUsername(token);
			}
			if (user != null) {
				UserDetails ud = service.loadUserByUsername(user);
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(ud, null,
						ud.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filter.doFilter(request, response);
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}
}
