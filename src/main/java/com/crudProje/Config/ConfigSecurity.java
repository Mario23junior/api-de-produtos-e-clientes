package com.crudProje.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	
	@Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
	   
		 auth. 
		  inMemoryAuthentication()
			  .withUser("nameuser")
			  .password("123")
			  .roles("USER");
   }
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
		
	}
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
	 http.
		csrf().disable()
		.cors()
	 .and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 
	}

}
