package com.zjw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Hello")
public class HelloController {
    @RequestMapping("/Hello")
    public ModelAndView Hello(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("Hello.jsp");
        mav.addObject("message", "Hello My First Spring MVC");
        return mav;
    }
    @RequestMapping("/Git")
    public ModelAndView Git(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("Hello.jsp");
        mav.addObject("message", "Hello My First Git Project");
        return mav;
    }
}