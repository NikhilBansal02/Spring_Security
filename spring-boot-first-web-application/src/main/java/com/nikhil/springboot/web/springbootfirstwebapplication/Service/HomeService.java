package com.nikhil.springboot.web.springbootfirstwebapplication.Service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@Secured("USER")
	public String getHomeWelcomeMessage() {
		return "Welcome Home.!!!";
	}

}
