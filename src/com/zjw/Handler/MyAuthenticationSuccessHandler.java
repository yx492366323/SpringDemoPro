package com.zjw.Handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public MyAuthenticationSuccessHandler(){}

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> Authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if(Authorities.contains("DEV")){
            httpServletResponse.sendRedirect("/swagger-ui.html");
        }
        else{
            if(Authorities.contains("ADMIN")){
                httpServletResponse.sendRedirect("/Admin/");
            }
            else{
                    httpServletResponse.sendRedirect("/user.html");
            }
        }
    }
}


