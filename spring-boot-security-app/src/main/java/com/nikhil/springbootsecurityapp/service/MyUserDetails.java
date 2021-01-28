package com.nikhil.springbootsecurityapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nikhil.springbootsecurityapp.model.Users;

@Component
public class MyUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	List<SimpleGrantedAuthority> authorities;
	
	public MyUserDetails() {
		
	}
	
	public MyUserDetails(Users users) {
		
		this.username = users.getUsername();
		this.password = users.getPassword();
		this.authorities = Arrays.stream(users.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		System.out.println(authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
