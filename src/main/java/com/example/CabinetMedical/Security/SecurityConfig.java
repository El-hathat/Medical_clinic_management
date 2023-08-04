package com.example.CabinetMedical.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.CabinetMedical.Services.MedcinService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	private final String[] PUBLIC_ENDPOINTS = {
	            "/api/v1/registrer",
			"/api/v1/medcins",
			"/api/v1/auth",
			"/api/v1/currentUser",
			"/**",
	    };

	 @Bean
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	     return super.authenticationManagerBean();
	 }
	 
	 @Bean
	 public AuthFilter authFilter() {
		 return new AuthFilter();
	 }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	  http
	            .cors().and().csrf().disable()
	            .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	            .authorizeRequests()
	                .antMatchers(PUBLIC_ENDPOINTS).permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
	   
	    }
}
