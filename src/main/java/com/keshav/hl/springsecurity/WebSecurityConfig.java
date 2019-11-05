package com.keshav.hl.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	BasicAuthenticationPoint basicAuthenticationPoint;
	
	
	 @Bean
	 public UserDetailsService userDetailsService() {
	     return super.userDetailsService();
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
			 http
			 .csrf().disable()
			.authorizeRequests()
			.antMatchers("/","/api/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.authenticationEntryPoint(basicAuthenticationPoint);	
	}
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		auth.inMemoryAuthentication().withUser("keshav").password("$2y$12$5oHhoxrWDu2lz4yT709SxOFdvPxnCI4lCG36sZ5maTHfymdvkwt4K").roles("USER");
		}

	
	
}
