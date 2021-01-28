package com.nikhil.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nikhil.springboot.web.springbootfirstwebapplication.Service.LoginService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
public class LoginController {
		@Autowired
		LoginService service;
		//This will simply print what is being returned.
		/*@RequestMapping("/login")
		//@ResponseBody
		public String loginMessage() {
			return "login";
		}*/
		
		//This will redirect to login.jsp page , name in url
		/*@RequestMapping("/login")
		public String loginMessage(@RequestParam String name, ModelMap model) {
			model.put("name",name);
			return "login";
		}*/
	
	
			//This will redirect to login.jsp page , nothing in url
			@RequestMapping(value = "/", method = RequestMethod.GET)
			public String loginMessage(ModelMap model) {
				model.put("name", "in28Minutes");
				return "welcome";
			}
}
