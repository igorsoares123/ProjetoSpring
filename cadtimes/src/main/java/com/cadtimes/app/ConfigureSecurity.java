package com.cadtimes.app;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("igor")
		.password("igor")
		.roles("USER")
		.and()	
		.withUser("iran")
		.password("iran")
		.roles("ADMIN")
		.and().withUser("ihesus")
		.password("ihesus")				
		.roles("ADMIN");
			
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		
		.antMatchers("/resources**", "/webjars/**").permitAll()
	
		.antMatchers("/salvar").hasAnyRole("ADMIN", "USER")
		.antMatchers("/view").hasAnyRole("ADMIN", "USER")
		.antMatchers("/delete/codigo").hasRole("ADMIN")
		.antMatchers("/editar/codigo").hasRole("ADMIN")	
		.anyRequest().authenticated()
		.and()
		.formLogin();
	}
   
}
