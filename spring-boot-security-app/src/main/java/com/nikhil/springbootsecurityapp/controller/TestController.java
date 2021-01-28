package com.nikhil.springbootsecurityapp.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoginMessageForAnyone() {
		return "Welcome Anyone";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getLoginMessageUser() {
		return "Welcome User";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getLoginMessageAdmin() {
		return "Welcome Admin";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String checkSecuredAnnotation() {
		return "dashboard";
	}
	
	@RolesAllowed("ROLE_USER")
	@RequestMapping(value = "/roleAllowed", method = RequestMethod.GET)
	public String checkRoleAllowedAnnotation() {
		return "roleAllowed";
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')") // Similar to @Secured annotation
	@RequestMapping(value = "/preAuthorize", method = RequestMethod.GET)
	public String checkPreAuthorizeAnnotation() {
		return "preAuthorize";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	public String getUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/getUserNameBySpringAuthentication", method = RequestMethod.GET)
	public String getUserNameBySpringAuthentication(Authentication authentication) {
		return authentication.getName();
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/getUserNameBySpringPrincipal", method = RequestMethod.GET)
	public String getUserNameBySpringPrincipal(Principal principal) {
		return principal.getName();
	}
	
}
