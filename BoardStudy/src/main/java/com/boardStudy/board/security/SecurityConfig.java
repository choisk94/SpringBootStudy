package com.boardStudy.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.userDetailsService(userDetailsService);
		
		security.authorizeRequests().antMatchers("/","/system/**").permitAll();		// '/'와 'system'으로 시작하는 경로에는 인증되지 않은 모든 사용자 접근 가능
		security.authorizeRequests().antMatchers("/board/**").authenticated();		// '/board'로 시작하는 경로에는 인증된 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");		// '/admin'으로 시작하는 경로에는 ADMIN권한을 가진 사용자만 접근 가능
		
		security.csrf().disable();
		security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true);		// 인증되지 않은 사용자가 /board로 시작하는 경로 요청 시 system/login으로 라다이렉트. 로그인 성공했으면 게시글 목록 화면 board/getBoardList로 리다이렉트.
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");	
		security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");	// 로그아웃 url을 요청하면 세선 강제 종료 및 인덱스 페이지로 이동
	}
	
}
