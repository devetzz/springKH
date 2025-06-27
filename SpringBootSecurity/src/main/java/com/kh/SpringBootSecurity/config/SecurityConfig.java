package com.kh.SpringBootSecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.kh.SpringBootSecurity.common.security.CustomAccessDeniedHandler;
import com.kh.SpringBootSecurity.common.security.CustomLoginSuccessHandler;
import com.kh.SpringBootSecurity.common.security.CustomNoOpPasswordEncoder;
import com.kh.SpringBootSecurity.common.security.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity // Spring Security를 활성화
// 인가 정책을 각 개발자에게 위임
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("security config ...");
        // CSRF 토큰 비활성화
        http.csrf().disable();

        // 로그인 인가 정책
        // http.authorizeRequests().requestMatchers("/board/list").permitAll();
        // http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
        // http.authorizeRequests().requestMatchers("/notice/list").permitAll();
        // http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");

        // 로그인(인증, 인가) 정책 실패 시 (403 페이지, formLogin() => 실패화면 대체)
        // 접근 거부 처리자에 대한 페이지 이동 URI를 지정
        http.exceptionHandling().accessDeniedPage("/accessError");

        
        // 로그인 인증 정책
        // username : test, password : 123456, role : manager
        // http.formLogin();
        // 개발자가 정의한 로그인 페이지의 URI를 지정한다.
        // 로그인 성공 후 처리를 담당하는 처리자로 지정한다.
        // http.formLogin().loginPage("/login");
        http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

        // 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
        // 로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제해 주도록 한다.
        // http.logout().logoutUrl("/logout").invalidateHttpSession(true);
        http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me","JSESSION_ID");

        // 등록한 CustomAccessDeniedHandler.java를 접근 거부 처리자로 지정한다.
        http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());


        // 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
        // 쿠키의 유효 시간을 지정한다(24시간).
        http.rememberMe().key("zeus").tokenRepository(createJDBCRepository()).tokenValiditySeconds(60*60*24);

        return http.build();
    }

    // @Autowired
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     // 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
    //     auth.inMemoryAuthentication().withUser("member").password("{noop}123456").roles("MEMBER");
    //     auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN", "MEMBER");
    // }

    private PersistentTokenRepository createJDBCRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    // @Autowired 진행하지 말 것!
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
    }

    // 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록
    @Bean
    public UserDetailsService createUserDetailsService() {
        return new CustomUserDetailsService();
    }

    // 사용자가 정의한 PW 암호화 처리기를 빈으로 등록
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new CustomNoOpPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
}
