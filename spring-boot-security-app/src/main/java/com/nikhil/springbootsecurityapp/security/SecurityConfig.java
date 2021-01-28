package com.nikhil.springbootsecurityapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth
//		.inMemoryAuthentication()
//		.withUser("user")
//		.password("user")
//		.roles("USER")
//		.and()
//		.withUser("admin")
//		.password("admin")
//		.roles("ADMIN");
//		
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Authenticate");
		auth
		.userDetailsService(userDetailsService);
		
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Authorize");
		http
		.authorizeRequests()
				.antMatchers("/admin").hasAnyRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER","ADMIN")
				.antMatchers("/test").denyAll()
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout().deleteCookies("remove").invalidateHttpSession(true)
 				.logoutUrl("/logout").logoutSuccessUrl("/login")
				.and()
				.httpBasic();

	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2-console/**");
    }

}
