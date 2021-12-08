package com.zjw.Config;

import com.zjw.Handler.MyAuthenticationSuccessHandler;
import com.zjw.Service.Impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity  // ����web�����µ�Ȩ�޿��ƹ���
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //��¼
        http.formLogin()
//                �Զ���������ƣ���login.html�еĵ�¼��������Ӧ
                .usernameParameter("username").passwordParameter("password")
                .loginPage("/Login/login").loginProcessingUrl("/Login/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureForwardUrl("/Login/loginerror");
//        //��ס��
        http.rememberMe();
        //�ǳ�
        http.logout().logoutUrl("/Login/logout").logoutSuccessUrl("/Login/login").logoutRequestMatcher(new AntPathRequestMatcher("/Login/login", "GET"));
        //��Ȩ
        http.authorizeRequests()
                //����ҳ��
                .antMatchers("/index.jsp","/Login/**").permitAll()
                .antMatchers("/user.html","/UserPrint/*","/upload","/test").hasAuthority("USER")
                .antMatchers("/ManageUser/**","/Admin/**","/AdminPrint/**").hasAuthority("ADMIN")
                .antMatchers("/swagger-ui.html","/Hello/**").hasAuthority("DEV")
                .anyRequest().hasAuthority("DEV");
        //���úÿ����������ǰ�ر�һ�¿��������
//        http.csrf().disable();
        //X-Frame-Options
        http.headers().frameOptions().sameOrigin();
    }
}

