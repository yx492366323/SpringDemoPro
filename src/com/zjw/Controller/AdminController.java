package com.zjw.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView Login(Authentication authentication) throws Exception {
        System.out.println("Request: GET:/Admin/");
        ModelAndView mav = new ModelAndView("admin.jsp");
        mav.addObject("username", authentication.getName());
        return mav;
    }
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public ModelAndView Upload() throws Exception {
        System.out.println("Request: GET:/Admin/upload");
        ModelAndView mav = new ModelAndView("upload.jsp");
        return mav;
    }
    @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    public ModelAndView Userinfo() throws Exception {
        System.out.println("Request: GET:/Admin/userinfo");
        ModelAndView mav = new ModelAndView("userinfo.jsp");
        return mav;
    }
}
