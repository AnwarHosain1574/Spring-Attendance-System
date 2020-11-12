package com.csl.bmsri.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource datasource; //sql datasource
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select email, password, active from user_login_bk where email=?")
		.authoritiesByUsernameQuery("select u.email, r.role from user_login_bk u,  user_role ur, role r "
					+"where u.login_id = ur.user_id and ur.role_id=r.role_id and u.email=?")
		.dataSource(datasource);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/*").hasAnyAuthority("Admin","Customer").anyRequest()
		.authenticated().and().csrf().disable()
		.formLogin().loginPage("/login").failureUrl("/login?errorParam=true")
		.defaultSuccessUrl("/home")
		.usernameParameter("email")
		.passwordParameter("password")
		.and().logout()
		.logoutSuccessUrl("/");
	}

}
