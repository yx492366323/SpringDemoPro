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
@EnableWebSecurity  // 启动web环境下的权限控制功能
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
        //登录
        http.formLogin()
//                自定义参数名称，与login.html中的登录表单参数对应
                .usernameParameter("username").passwordParameter("password")
                .loginPage("/Login/login").loginProcessingUrl("/Login/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureForwardUrl("/Login/loginerror");
//        //记住我
        http.rememberMe();
        //登出
        http.logout().logoutUrl("/Login/logout").logoutSuccessUrl("/Login/login").logoutRequestMatcher(new AntPathRequestMatcher("/Login/login", "GET"));
        //授权
        http.authorizeRequests()
                //放行页面
                .antMatchers("/index.jsp","/Login/**").permitAll()
                .antMatchers("/user.html","/UserPrint/*","/upload","/test").hasAuthority("USER")
                .antMatchers("/ManageUser/**","/Admin/**","/AdminPrint/**").hasAuthority("ADMIN")
                .antMatchers("/swagger-ui.html","/Hello/**").hasAuthority("DEV")
                .anyRequest().hasAuthority("DEV");
        //配置好跨域相关内容前关闭一下跨域防护。
//        http.csrf().disable();
        //X-Frame-Options
        http.headers().frameOptions().sameOrigin();
    }
}

