package com.projectname.backend.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.projectname.backend.constants.SecurityConstants;
import com.projectname.backend.service.UserService;
import com.projectname.backend.util.BCryptPasswordEncoderUtil;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserService userService;
	// private UserDetailsServiceImpl userDetailsService;

	// private BCryptPasswordEncoder bCryptPasswordEncoder;
	private BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

	public WebSecurity(UserService userService) {
		this.userService = userService;
	}

//	public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.userService = userService;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.authorizeHttpRequests().anyRequest().permitAll();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.cors().and().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
//				.anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
//				.addFilter(new JWTAuthorizationFilter(authenticationManager()))
//				// this disables session creation on Spring Security
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder);
//	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();

		source.registerCorsConfiguration("/**", corsConfiguration);

		return source;

	}

}
