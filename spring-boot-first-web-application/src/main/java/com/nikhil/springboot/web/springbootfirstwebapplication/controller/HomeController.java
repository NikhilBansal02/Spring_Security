package com.nikhil.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.springboot.web.springbootfirstwebapplication.Service.HomeService;

@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getToHome() {
		return homeService.getHomeWelcomeMessage();
	}

}
