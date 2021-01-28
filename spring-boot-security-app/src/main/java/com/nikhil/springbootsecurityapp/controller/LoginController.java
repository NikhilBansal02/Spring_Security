package com.nikhil.springbootsecurityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nikhil.springbootsecurityapp.model.Users;
import com.nikhil.springbootsecurityapp.repository.UsersRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout() {
		return "logout";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignUp() {
		return "signup";
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String createAccount( Users user) {
		user.setRole("ROLE_USER");
		usersRepository.save(user);
		return "welcome";
		
	}
}
