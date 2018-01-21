package config.securityConfig;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import root.DBConnect;
import root.SpitterUserService;

@Configuration
//@EnableWebMvcSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	/**
	 * 用户认证
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//启用内存用户存储
//		auth.inMemoryAuthentication()
//		.withUser("admin").password("landsea").roles("USER").and()
//		.withUser("tracy").password("wangshuhe123").roles("ADMIN");
		
		//配置数据库认证
//		auth.jdbcAuthentication().dataSource(dbConnect.getDataSource())
//		.usersByUsernameQuery("select username,password, "
//				+ "true from sys_user where username = ?");
		
		//用户自定义的认证
		auth.userDetailsService(new SpitterUserService());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	/**
	 * 拦截请求
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/spitter/register").access("hasRole('ROLE_ADMIN')")
//		.anyRequest().permitAll()
//		.and()
//		.formLogin();
		http.formLogin().loginPage("/login.jsp")
		.and()
		.authorizeRequests()
		.antMatchers("/spitter/register").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
		.csrf().disable();
		
	}
	
}
