//package com.nikhil.springboot.web.springbootfirstwebapplication;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.nikhil.springboot.web.springbootfirstwebapplication.model.User;
//import com.nikhil.springboot.web.springbootfirstwebapplication.repository.UserRepository;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Optional<User> user = userRepository.findbyUsername(username);
//		user.orElseThrow(() -> new UsernameNotFoundException("Not Found :" + username));
//		return user.map(MyUserDetails::new).get();
//	}
//
//}
