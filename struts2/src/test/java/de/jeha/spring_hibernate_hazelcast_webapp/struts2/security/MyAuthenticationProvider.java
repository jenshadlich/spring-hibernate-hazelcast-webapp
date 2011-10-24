package de.jeha.spring_hibernate_hazelcast_webapp.struts2.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;

public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		User user = null;
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));

		user = new User(username, password, true, true, true, true, grantedAuthorities);
		return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), grantedAuthorities);
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
