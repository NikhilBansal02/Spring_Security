package com.nikhil.springboot.web.springbootfirstwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	  protected void configure(HttpSecurity http) throws Exception {  // (2)
	      http
	        .authorizeRequests()
	          .antMatchers("/", "/login").
	          permitAll() // (3)
	          .anyRequest()
	          .authenticated() // (4)
	          .and()
	       .formLogin() // (5)
				// .loginPage("/welcome") // (5)
				// .permitAll()
	         .and()
	      .logout() // (6)
	        .permitAll()
	        .and()
	      .httpBasic(); // (7)
	  }
}
