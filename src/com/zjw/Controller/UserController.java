package com.zjw.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView Index(Authentication authentication) throws Exception {
        System.out.println("Request: GET:/User/");
        ModelAndView mav = new ModelAndView("user.jsp");
        mav.addObject("username", authentication.getName());
        return mav;
    }
}
