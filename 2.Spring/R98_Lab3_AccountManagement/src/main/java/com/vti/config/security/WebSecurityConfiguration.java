package com.vti.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.vti.service.IAccountService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

	@Autowired
	private IAccountService accountService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(cors -> {
		}).authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/accountsRegister/**").permitAll()
				// ================= Account =================
				.requestMatchers(HttpMethod.POST, "/api/v1/accounts/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/v1/accounts/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/v1/accounts/**").hasRole("ADMIN").

				requestMatchers(HttpMethod.GET, "/api/v1/accounts/**").hasAnyRole("ADMIN", "USER")
				// ================= DEPARTMENT =================
				.requestMatchers(HttpMethod.GET, "/api/v1/departments/**").hasAnyRole("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/api/v1/departments/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/v1/departments/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/v1/departments/**").hasRole("ADMIN")

				// ================= POSSITION =================
				.requestMatchers(HttpMethod.GET, "/api/v1/possitions/**").hasAnyRole("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/api/v1/possitions/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/v1/possitions/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/v1/possitions/**").hasRole("ADMIN")

				.anyRequest().authenticated()).httpBasic();

		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(accountService);
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
}
