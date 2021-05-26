package org.gsef.eventfinder.configs;

import org.gsef.eventfinder.security.CustomUserDetailService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	@Value("${app.login.success.url}")
	private String loginSuccessUrl;
	
	@Value("${app.login.failure.url}")
	private String loginFailureUrl;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new CustomUserDetailService(userService));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll()
			.antMatchers("/account/**", "/graphql").hasRole("USER")
			.and().formLogin().usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/login")
				.failureUrl(loginFailureUrl)
				.successHandler((req, resp, auth) -> {
					resp.setStatus(200);
					})
			.and().cors().and().csrf().disable();
		//@formatter:on
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}
