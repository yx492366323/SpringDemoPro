package com.zjw.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity  // ����web�����µ�Ȩ�޿��ƹ���
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

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
                //�Զ���������ƣ���login.html�еĵ�¼��������Ӧ
                //.usernameParameter("myusername").passwordParameter("mypassword")
                .loginPage("/login.html").loginProcessingUrl("/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureForwardUrl("/loginerror.html");
        //��ס��
        http.rememberMe();
        //�ǳ�
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
        //��Ȩ
        http.authorizeRequests()
                //����ҳ��
                .antMatchers("/","/error/**","/staticresources/**","/js/**","/css/**","/font/**","/login.html","/register.html","/forgot.html","/agreement.html","/User/*","/login","/logout").permitAll()
                .antMatchers("/user.html","/UserPrint/*","/upload","/test").hasAuthority("USER")
                .antMatchers("/ManageUser/**","/Admin/**","/AdminPrint/**").hasAuthority("ADMIN")
                .antMatchers("/swagger-ui.html").hasAuthority("DEV")
                .anyRequest().hasAuthority("DEV");
        //���úÿ����������ǰ�ر�һ�¿��������
//        http.csrf().disable();
        //X-Frame-Options
        http.headers().frameOptions().sameOrigin();
    }
}

