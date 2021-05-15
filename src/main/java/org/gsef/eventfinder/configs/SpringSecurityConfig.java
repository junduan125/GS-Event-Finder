package org.gsef.eventfinder.configs;

import org.gsef.eventfinder.jpa.service.EndUsers;
import org.gsef.eventfinder.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	EndUsers endUsersRepo;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new CustomUserDetailService(endUsersRepo));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/account/**").access("hasRole('ROLE_USER')")
			.and().formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password");
		//@formatter:on
	}
}
