package com.zjw.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity  // 启动web环境下的权限控制功能
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
        //登录
        http.formLogin()
                //自定义参数名称，与login.html中的登录表单参数对应
                //.usernameParameter("myusername").passwordParameter("mypassword")
                .loginPage("/login.html").loginProcessingUrl("/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureForwardUrl("/loginerror.html");
        //记住我
        http.rememberMe();
        //登出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
        //授权
        http.authorizeRequests()
                //放行页面
                .antMatchers("/","/error/**","/staticresources/**","/js/**","/css/**","/font/**","/login.html","/register.html","/forgot.html","/agreement.html","/User/*","/login","/logout").permitAll()
                .antMatchers("/user.html","/UserPrint/*","/upload","/test").hasAuthority("USER")
                .antMatchers("/ManageUser/**","/Admin/**","/AdminPrint/**").hasAuthority("ADMIN")
                .antMatchers("/swagger-ui.html").hasAuthority("DEV")
                .anyRequest().hasAuthority("DEV");
        //配置好跨域相关内容前关闭一下跨域防护。
//        http.csrf().disable();
        //X-Frame-Options
        http.headers().frameOptions().sameOrigin();
    }
}

