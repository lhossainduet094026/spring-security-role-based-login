package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity // @EnableWebSecurity enables Web security; otherwise, it remains disabled by
					// default.
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//The advantage of extending the adapter class is that we can configure Web security by overriding only those parts that we are interested in
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);

		// add our users for in Memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("lokman").password("12345").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("salman").password("234").roles("MANAGER", "EMPLOYEE"))
				.withUser(users.username("pavel").password("987").roles("EMPLOYEE", "ADMIN"));

	}

//custom login page added with processing url who validate user name and password 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
		        .antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateUser").permitAll()
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
