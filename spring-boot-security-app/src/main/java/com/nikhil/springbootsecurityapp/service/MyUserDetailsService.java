package com.nikhil.springbootsecurityapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nikhil.springbootsecurityapp.model.Users;
import com.nikhil.springbootsecurityapp.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("MyUserDetailsService :"+username);
		Optional<Users> users = usersRepository.findByusername(username);
		//System.out.println("users Name :"+users.get().getUsername());
		//System.out.println("users Role :"+users.get().getRole());
		users.orElseThrow(() -> new UsernameNotFoundException("User Not found :"+username) );
		
		return users.map(MyUserDetails::new).get();
		
	}

}
