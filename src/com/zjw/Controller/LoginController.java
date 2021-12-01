package com.zjw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView Login(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("login.jsp");
        System.out.println("Login");
//        mav.addObject("message", "Hello My First Spring MVC");
        return mav;
    }
//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public ModelAndView Test(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//
//    }
}
