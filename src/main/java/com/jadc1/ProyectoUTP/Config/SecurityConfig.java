package com.jadc1.ProyectoUTP.Config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.jadc1.ProyectoUTP.Model.UserModel;
import com.jadc1.ProyectoUTP.ModelDAO.UserDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**/
		
		
		/*auth.jdbcAuthentication().dataSource(null)
			.usersByUsernameQuery("SELECT usuario, password, tipo FROM usuarios WHERE usuario = ?")
			
			
		usuarios.forEach(user ->{
			auth.inMemoryAuthentication()
				.withUser(users.username(user.getUsuario()).password(user.getPassword()).roles(user.getTipo()));
		});
			;*/
		
		UserDAO userDAO = new UserDAO();
		List<UserModel> usuarios = userDAO.listar(null);
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("Alex").password("123").roles("ADMIN"))
		.withUser(users.username("Javier").password("456").roles("USER"))
		.withUser(users.username("Alfa").password("alfa").roles("TRABAJADOR"))
		;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		/*http.authorizeRequests().anyRequest().authenticated().and().formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginUser")
			.permitAll()
			.and().logout().permitAll();*/
		http
	      .csrf().disable()
	      .authorizeRequests()
	      .antMatchers("/admin/**").hasAnyRole("TRABAJADOR", "ADMIN")
	      .antMatchers("/anonymous*").anonymous()
	      .antMatchers("/login*").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login")
	      .loginProcessingUrl("/loginUser")
	      .defaultSuccessUrl("/home", true)
	      .failureUrl("/login?error")
	      //.failureHandler(authenticationFailureHandler())
	      .and()
	      .logout()
	      .logoutUrl("/logout")
	      .deleteCookies("JSESSIONID");
	      //.logoutSuccessHandler(logoutSuccessHandler());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/Resources/**").antMatchers("/auth/logup");
	}
	
	
}
